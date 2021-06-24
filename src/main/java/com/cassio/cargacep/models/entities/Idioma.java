package com.cassio.cargacep.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "TB_IDIOMAS")
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SIGLA_IDIOMA")
    private String sigla;

    @Column(name = "IDIOMA")
    private String nomeIdioma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeIdioma() {
        return nomeIdioma;
    }

    public void setNomeIdioma(String nomeIdioma) {
        this.nomeIdioma = nomeIdioma;
    }

    @Override
    public String toString() {
        return "Idioma{" +
                "id=" + id +
                ", sigla='" + sigla + '\'' +
                ", idioma='" + nomeIdioma + '\'' +
                '}';
    }
}
