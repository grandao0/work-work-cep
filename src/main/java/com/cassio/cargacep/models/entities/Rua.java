package com.cassio.cargacep.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "TB_RUAS")
public class Rua {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_BAIRRO")
    private Bairro bairro;

    @Column(name = "RUA")
    private String nomeRua;

    @Column(name = "CEP")
    private Long cep;

    @Column(name = "TIPO")
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Rua{" +
                "id=" + id +
                ", rua='" + nomeRua + '\'' +
                ", cep=" + cep +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
