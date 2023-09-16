package br.com.fiap.brqchallenge.models;

import br.com.fiap.brqchallenge.enums.EnumTipoTelefone;

public class Telefone extends AbstractModel {

    private String nrTelefone;
    private String nrDdd;
    private EnumTipoTelefone tipoTelefone;

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public String getNrDdd() {
        return nrDdd;
    }

    public void setNrDdd(String nrDdd) {
        this.nrDdd = nrDdd;
    }

    public EnumTipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(EnumTipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
