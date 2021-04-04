package com.example.cartoriosdocket.service;

import org.springframework.stereotype.Service;

import com.example.cartoriosdocket.model.Cartorio;
import java.util.Set;

@Service
public interface ICartorioService extends ICrudService<Cartorio, Long> {

    /**
     * pega todos os cartorios do banco
     * @return  um Set contendo cartorios
     */
    Set<Cartorio> getAll();

    /**
     * encontra um livro no banco pelo seu id
     * @param cartorioId    id do cartorio no banco
     * @return          cartorio com id = cartorioId
     */
    Cartorio findById(Long cartorioId);

    /**
     * cria e salva um novo cartorio no banco
     * @param cartorioDetails      detalhes do cartorio do form de novo cartorio
     * @return                 id do novo cartorio
     */
    Long create(Cartorio cartorioDetails);

    /**
     * Atualiza um cartorio com
     * @param cartorioId                id do cartorio
     * @param cartorioDetails           detalhes do cartorio pelo form de edicao
     */
    void update(Long cartorioId, Cartorio cartorioDetails);

    /**
     * deleta um cartorio do banco
     * @param cartorioId     id do cartorio
     */
    void delete(Long cartorioId);

}
