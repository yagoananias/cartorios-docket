package com.example.cartoriosdocket.model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cartorios")
public class Cartorio {

    @Id
    @Column(name = "cartorio_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String endereco;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cartorio_certidao",
            joinColumns = { @JoinColumn(name = "cartorio_id") },
            inverseJoinColumns = { @JoinColumn(name = "certidao_id") })
    private Set<Certidao> certidoes = new HashSet<>();

    public Cartorio(){}

    public Set<Certidao> getCertidoes() {
        return certidoes;
    }

    public void setCertidoes(Set<Certidao> certidoes) {
        this.certidoes = certidoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
