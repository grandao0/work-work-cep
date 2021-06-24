package com.cassio.cargacep.models;

public class CepCidades {

    private int tipoCep;

    private String cep;

    private String siglaUf;

    private String nomeUf;

    private String nomeLocalidade;

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

    @Override
    public String toString() {
        return tipoCep + cep + siglaUf + nomeUf + nomeLocalidade;
    }
}
