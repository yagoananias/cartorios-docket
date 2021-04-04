package com.example.cartoriosdocket.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "certidoes")
public class Certidao {

    @Id
    @Column(name ="cert_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotEmpty
    private String nome;

    @ManyToMany(mappedBy = "certidoes")
    private Set<Cartorio> cartorios;

    public Certidao() {}

    public Certidao(@NotEmpty String nome) {
        this.nome = nome;
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

    public Set<Cartorio> getCartorios() {
        return cartorios;
    }

    public void setCartorios(Set<Cartorio> cartorios) {
        this.cartorios = cartorios;
    }
}

