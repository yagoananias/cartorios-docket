package com.example.cartoriosdocket.service;


import com.example.cartoriosdocket.model.Cartorio;
import com.example.cartoriosdocket.repository.ICartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CartorioServiceImpl implements ICartorioService {

    @Autowired
    private ICartorioRepository cartorioRepository;

    /**
     * pega todos os cartorios do banco
     * @return  retorna um Set contendo cartorios
     */
    @Override
    public Set<Cartorio> getAll(){
        Set<Cartorio> cartorioSet = new HashSet<>();
        cartorioRepository.findAll().iterator().forEachRemaining(cartorioSet::add);
        return cartorioSet;
    }

    /**
     * encontra um cartorio no banco pelo seu id
     * @param cartorioId    Id do cartorio gravado no banco
     * @return          Cartorio com ID = cartorioId
     */
    @Override
    public Cartorio findById(Long cartorioId){
        Optional<Cartorio> cartorioOptional = cartorioRepository.findById(cartorioId);

        if (!cartorioOptional.isPresent()) {
            throw new RuntimeException("Cartório não encontrado!");
        }
        return cartorioOptional.get();
    }

    /**
     * Atualiza um cartorio
     * @param cartorioId                ID do cartorio
     * @param cartorioDetails           detalhes do cartorio no edit form
     */
    @Override
    public void update(Long cartorioId, Cartorio cartorioDetails){
        Cartorio currentCartorio = findById(cartorioId);
        currentCartorio.setNome(cartorioDetails.getNome());
        currentCartorio.setEndereco(cartorioDetails.getEndereco());
        currentCartorio.setCertidoes(cartorioDetails.getCertidoes());

        cartorioRepository.save(currentCartorio);
    }

    /**
     * deleta um cartorio do banco
     * @param cartorioId     ID do cartorio
     */
    @Override
    public void delete(Long cartorioId){
        cartorioRepository.deleteById(cartorioId);
    }

    /**
     * cria e salva um novo cartorio no banco
     * @param cartorioDetails      form de detalhes do cartorio de um novo cartorio
     * @return                 id do novo cartorio
     */
    @Override
    public Long create(Cartorio cartorioDetails){
        cartorioRepository.save(cartorioDetails);
        return cartorioDetails.getId();
    }
}
