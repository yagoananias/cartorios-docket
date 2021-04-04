package com.example.cartoriosdocket.controller;

import com.example.cartoriosdocket.model.Certidao;
import com.example.cartoriosdocket.model.Cartorio;
import com.example.cartoriosdocket.service.ICertidaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;
@Controller
public class CertidaoController {

    @Autowired
    private ICertidaoService certidaoService;

    /**
     * Retorna um form para nova certidao
     * @param model     contem Certidao Object
     * @return          template Form para nova certidao
     */
    @RequestMapping( path = "/certidao/create")
    public String newCertForm(Model model) {
        model.addAttribute("certidao", new Certidao());
        return "certidoes/new";
    }

    /**
     * Salva os Detalhes do Form da nova certidao no banco
     * @param certidao   contem valores dos campos
     * @return           redirect para lista de certidoes
     */
    @RequestMapping(path = "/certidao", method = RequestMethod.POST)
    public String saveNewCertidao(Certidao certidao) {
        long id = certidaoService.create(certidao);
        return "redirect:/certidoes";
    }

    /**
     * Retorna um form de edicao para uma certidao existente
     * @param id        Id da Certidao
     * @param model     contem Certidao Object
     * @return          Form de edicao
     */
    @GetMapping("/certidao/{id}")
    public String editCertidaoForm(@PathVariable("id") long id, Model model) {
        Certidao certidao = certidaoService.findById(id);
        model.addAttribute("certidao", certidao);
        return "certidoes/edit";
    }

    /**
     * Mostra Cartorios por certidao
     * @param certidao_id        certidao_id
     * @param model              contem uma Certidao e seus Cartorios
     * @return                   list view de cartorios
     */
    @GetMapping("/certidao/cartorios/{id}")
    public String showCartoriosByCertidao(@PathVariable("id") long certidao_id, Model model) {
        Certidao certidao = certidaoService.findById(certidao_id);
        Set<Cartorio> cartorios = certidao.getCartorios();
        model.addAttribute("certidao", certidao);
        model.addAttribute("cartorios", cartorios);
        return "certidoes/showById";
    }

    /**
     * Lista todas as certidoes existentes no banco
     * @param model         contem Certidoes do banco
     * @return              list view de certidoes
     */
    @GetMapping("/certidoes")
    public String showAllCertidoes(Model model) {
        model.addAttribute("certidoes", certidaoService.getAll());
        return "certidoes/list";
    }

    /**
     * Ao clicar em Salvar no form de edicao de certidao
     * os detalhes serao direcionados aqui
     * Salva as atualizacoes da certidao object existente no banco
     * @param id            certidao Id
     * @param certidao      valores dos campos do edit Form
     * @return
     */
    @RequestMapping(path = "/certidao/{id}", method = RequestMethod.POST)
    public String updateCertidao(@PathVariable("id") long id, Certidao certidao) {
        certidaoService.update(id, certidao);
        return "redirect:/certidoes";    }

    /**
     * Deleta um objeto existente
     * @param id            Certidao Id
     * @return              redirect uma list view de todas as certidoes
     */
    @RequestMapping(path = "/certidao/delete/{id}", method = RequestMethod.GET)
    public String deleteCertidao(@PathVariable("id") long id) {
        certidaoService.delete(id);
        return "redirect:/certidoes";
    }
}
