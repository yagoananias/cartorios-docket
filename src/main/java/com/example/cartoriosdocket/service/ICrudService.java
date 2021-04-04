package com.example.cartoriosdocket.service;

import java.util.Set;

public interface ICrudService<T, ID> {
    /**
     * pega todos os objetos do banco
     * @return todos os objetos do banco
     */
    Set<T> getAll();

    /**
     * encontra um obj pelo seu id
     * @param id    id do objeto no banco
     * @return      Object
     */
    T findById(ID id);

    /**
     * cria e salva um novo objeto no banco
     * @param tDetails   valores do campo
     * @return           novo Object
     */
    Long create(T tDetails);

    /**
     * atualiza um obj do banco com valores dos campos em tDetails
     * @param id        id do objeto no banco
     * @param tDetails  valores dos campos
     * @return          Object atualizado
     */
    void update(ID id, T tDetails);

    /**
     * deleta um objeto do banco
     * @param id    id do objeto no banco
     */
    void delete(ID id);
}
