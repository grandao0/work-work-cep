package com.cassio.cargacep.models;

public class CepRuas {

    private int tipoCep;

    private String cep;

    private String siglaUf;

    private String nomeUf;

    private String nomeLocalidade;

    private String nomeBairro;

    private String nomeBairroAbreviado;

    private String nomeTipoLogradouro;

    private String nomeTipoLogradouroAbreviado;

    private String nomeLogradouro;

    private String codIbgeEstado;

    private String codIbgeCidade;

    public int getTipoCep() {
        return tipoCep;
    }

    public void setTipoCep(int tipoCep) {
        this.tipoCep = tipoCep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public String getNomeUf() {
        return nomeUf;
    }

    public void setNomeUf(String nomeUf) {
        this.nomeUf = nomeUf;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public String getNomeBairroAbreviado() {
        return nomeBairroAbreviado;
    }

    public void setNomeBairroAbreviado(String nomeBairroAbreviado) {
        this.nomeBairroAbreviado = nomeBairroAbreviado;
    }

    public String getNomeTipoLogradouro() {
        return nomeTipoLogradouro;
    }

    public void setNomeTipoLogradouro(String nomeTipoLogradouro) {
        this.nomeTipoLogradouro = nomeTipoLogradouro;
    }

    public String getNomeTipoLogradouroAbreviado() {
        return nomeTipoLogradouroAbreviado;
    }

    public void setNomeTipoLogradouroAbreviado(String nomeTipoLogradouroAbreviado) {
        this.nomeTipoLogradouroAbreviado = nomeTipoLogradouroAbreviado;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCodIbgeEstado() {
        return codIbgeEstado;
    }

    public void setCodIbgeEstado(String codIbgeEstado) {
        this.codIbgeEstado = codIbgeEstado;
    }

    public String getCodIbgeCidade() {
        return codIbgeCidade;
    }

    public void setCodIbgeCidade(String codIbgeCidade) {
        this.codIbgeCidade = codIbgeCidade;
    }

    @Override
    public String toString() {
        return tipoCep + cep + siglaUf + nomeUf + nomeLocalidade
                + nomeBairro + nomeBairroAbreviado + nomeTipoLogradouro
                + nomeTipoLogradouroAbreviado + nomeLogradouro + codIbgeEstado + codIbgeCidade;
    }
}
