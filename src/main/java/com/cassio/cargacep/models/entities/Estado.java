package com.cassio.cargacep.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "TB_ESTADOS")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PAIS")
    private Pais pais;

    @Column(name = "ESTADO")
    private String nomeEstado;

    @Column(name = "UF")
    private String uf;

    @Column(name = "IBGE_ESTADO")
    private Long ibge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getIbge() {
        return ibge;
    }

    public void setIbge(Long ibge) {
        this.ibge = ibge;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", estado='" + nomeEstado + '\'' +
                ", uf='" + uf + '\'' +
                ", ibge=" + ibge +
                '}';
    }
}
