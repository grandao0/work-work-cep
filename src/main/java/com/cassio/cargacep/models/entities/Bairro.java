package com.cassio.cargacep.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "TB_BAIRROS")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADES")
    private Cidade cidade;

    @Column(name = "BAIRROS")
    private String nomeBairro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "id=" + id +
                ", bairro='" + nomeBairro + '\'' +
                '}';
    }
}
