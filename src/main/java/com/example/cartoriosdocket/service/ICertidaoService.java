package com.example.cartoriosdocket.service;

import com.example.cartoriosdocket.model.Certidao;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface ICertidaoService extends ICrudService<Certidao, Long> {

    /**
     * pega todas as certidoes do banco
     * @return  um Set contendo certidoes
     */
    Set<Certidao> getAll();

    /**
     * encontra uma certidao no banco pelo id
     * @param certId    id da certidao no banco
     * @return          certidao com id = certId
     */
    Certidao findById(Long certId);

    /**
     * cria e salva uma nova certidao no banco
     * @param certidaoDetails      detalhes da certidao do form de nova certidao
     * @return                     id da nova certidao
     */
    Long create(Certidao certidaoDetails);

    /**
     * Atualiza uma certidao com
     * @param certId                id da certidao
     * @param certidaoDetails      detalhes da certidao do form de edicao
     */
    void update(Long certId, Certidao certidaoDetails);

    /**
     * deleta uma certidao do banco
     * @param certId     id da certidao
     */
    void delete(Long certId);
}
