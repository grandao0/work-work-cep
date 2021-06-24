package com.cassio.cargacep.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "TB_CIDADES")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;

    @Column(name = "CIDADE")
    private String nomeCidade;

    @Column(name = "IBGE_CIDADE")
    private Long ibge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Long getIbge() {
        return ibge;
    }

    public void setIbge(Long ibge) {
        this.ibge = ibge;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", cidade='" + nomeCidade + '\'' +
                ", ibge=" + ibge +
                '}';
    }
}
