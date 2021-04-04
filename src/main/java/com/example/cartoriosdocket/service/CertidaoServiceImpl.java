package com.example.cartoriosdocket.service;

import com.example.cartoriosdocket.model.Certidao;
import com.example.cartoriosdocket.repository.ICertidaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CertidaoServiceImpl implements ICertidaoService{

    @Autowired
    private ICertidaoRepository certidaoRepository;

    /**
     * pega todas as certidoes do banco
     * @return  um Set contendo certidoes
     */
    @Override
    public Set<Certidao> getAll(){
        Set<Certidao> certidaoSet = new HashSet<>();
        certidaoRepository.findAll().iterator().forEachRemaining(certidaoSet::add);
        return certidaoSet;
    }

    /**
     * encontra uma certidao no banco pelo id
     * @param certId     id no banco de uma certidao
     * @return          Certidao com ID = certId
     */
    @Override
    public Certidao findById(Long certId){
        Optional<Certidao> certidaoOptional = certidaoRepository.findById(certId);

        if (!certidaoOptional.isPresent()) {
            throw new RuntimeException("Certidão não encontrada!");
        }
        return certidaoOptional.get();
    }

    /**
     * deleta uma certidao do banco
     * @param certId     Id da certidao
     */
    @Override
    public void delete(Long certId){
        certidaoRepository.deleteById(certId);
    }

    /**
     * cria e salva uma nova certidao no banco
     * @param certidaoDetails      Detalhes da certidao pelo form de nova certidao
     * @return                     id da nova certidao
     */
    @Override
    public Long create(Certidao certidaoDetails){
        certidaoRepository.save(certidaoDetails);
        return certidaoDetails.getId();
    }

    /**
     * atualiza um certidao com
     * @param certId                ID da certidao
     * @param certidaoDetails      Detalhes da certidao pelo form de edicao da certidao
     */
    @Override
    public void update(Long certId, Certidao certidaoDetails){
        Certidao currentCert = findById(certId);
        currentCert.setNome(certidaoDetails.getNome());

        certidaoRepository.save(currentCert);
    }

}
