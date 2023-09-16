package br.com.fiap.brqchallenge.models;

import br.com.fiap.brqchallenge.enums.EnumTipoEstado;
import br.com.fiap.brqchallenge.enums.EnumTipoLogradouro;

public class Endereco extends AbstractEntity {
    private String nmLogradouro;
    private EnumTipoLogradouro tipoLogradouro;
    private Integer nrLogradouro;
    private String nrCep;
    private String nmBairro;
    private String nmMunicipio;
    private EnumTipoEstado estado;

    public String getNmLogradouro() {
        return nmLogradouro;
    }

    public void setNmLogradouro(String nmLogradouro) {
        this.nmLogradouro = nmLogradouro;
    }

    public EnumTipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(EnumTipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public Integer getNrLogradouro() {
        return nrLogradouro;
    }

    public void setNrLogradouro(Integer nrLogradouro) {
        this.nrLogradouro = nrLogradouro;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getNmMunicipio() {
        return nmMunicipio;
    }

    public void setNmMunicipio(String nmMunicipio) {
        this.nmMunicipio = nmMunicipio;
    }

    public EnumTipoEstado getEstado() {
        return estado;
    }

    public void setEstado(EnumTipoEstado estado) {
        this.estado = estado;
    }
}