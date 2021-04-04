package com.example.cartoriosdocket.controller;

import com.example.cartoriosdocket.model.Certidao;
import com.example.cartoriosdocket.service.ICartorioService;
import com.example.cartoriosdocket.service.ICertidaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.cartoriosdocket.model.Cartorio;

import java.util.Set;

@Controller
public class CartorioController {

    @Autowired
    private ICartorioService cartorioService;
    @Autowired
    private ICertidaoService certidaoService;

    /**
     * Mostra um único cartório
     * @param id            cartorio Id
     * @param model         cartorio object
     * @return              template mostrando um unico cartorio
     */
    @RequestMapping( path = "/cartorio/show/{id}")
    public String showSingleCartorio(@PathVariable("id") long id, Model model) {
        Cartorio cartorio = cartorioService.findById(id);
        model.addAttribute("cartorio", cartorio);
        return "cartorios/showById";
    }

    /**
     * Form de novo cartorio
     * @param model     cartorio object
     * @return          template form para novo cartorio
     */
    @RequestMapping( path = "/cartorio/create")
    public String newCartorioForm(Model model) {
        model.addAttribute("cartorio", new Cartorio());
        Set<Certidao> certidoes = certidaoService.getAll();
        model.addAttribute("certidoes", certidoes);
        return "cartorios/new";
    }

    /**
     * salva os detalhes de "cartorio/create" no banco
     * @param cartorio      valores dos campos
     * @return          redirecionamento para visualizacao da lista de todos cartorios
     */
    @RequestMapping(path = "/cartorio", method = RequestMethod.POST)
    public String saveNewCartorio(Cartorio cartorio) {
        long id = cartorioService.create(cartorio);
        return "redirect:/cartorios";
    }

    /**
     * Form de edição
     * @param id        cartorio Id
     * @param model     cartorio object
     * @return          template para editar um cartorio
     */
    @GetMapping("/cartorio/{id}")
    public String editCartorioForm(@PathVariable("id") long id, Model model) {
        Cartorio cartorio = cartorioService.findById(id);
        Set<Certidao> certidoes = certidaoService.getAll();
        model.addAttribute("allCertidoes", certidoes);
        model.addAttribute("cartorio", cartorio);
        return "cartorios/edit";
    }

    /**
     * mostra todos os cartorios existentes no banco como uma lista
     * @param model     cartorio objects
     * @return          template para a view da lista
     */
    @GetMapping({"/cartorios", "/"})
    public String showAllCartorios(Model model) {
        model.addAttribute("cartorios", cartorioService.getAll());
        model.addAttribute("certidoes", certidaoService.getAll());
        return "index";
    }

    /**
     * Salva os detalhes do cartorio do template de edição de um cartorio existente no banco
     * @param id        cartorio Id
     * @param book      cartorio details (do valor dos campos)
     * @return          redirect para a lista de todos os cartorios
     */
    @RequestMapping(path = "/cartorio/{id}", method = RequestMethod.POST)
    public String updateCartorio(@PathVariable("id") long id, Cartorio cartorio) {
        cartorioService.update(id, cartorio);
        return "redirect:/cartorios";    }

    /**
     * deleta um cartorio existente do banco
     * @param id        cartorio Id
     * @return          redirect para a lista de todos os cartorios
     */
    @RequestMapping(path = "/cartorio/delete/{id}", method = RequestMethod.GET)
    public String deleteCartorio(@PathVariable("id") long id) {
        cartorioService.delete(id);
        return "redirect:/cartorios";
    }
}

