package br.com.fiap.brqchallenge.models;

import java.time.LocalDateTime;

public class Marca extends AbstractModel {
    private String nmMarca;

    public Marca() {
        super.cadastradoEm = LocalDateTime.now();
    }

    public String getNmMarca() {
        return nmMarca;
    }

    public void setNmMarca(String nmMarca) {
        this.nmMarca = nmMarca;
    }
}
