package br.com.fiap.brqchallenge.models;

import br.com.fiap.brqchallenge.enums.EnumCategoriaModeloVeiculo;
import br.com.fiap.brqchallenge.enums.EnumTipoCombustivel;

public class Modelo extends AbstractModel {

    private String nmModelo;
    private String nmCor;
    private int nrPortas;
    private String dsPlaca;
    private String dsRenavam;
    private String dsChassi;
    private String nmPaisOrigem;
    private Marca marca;
    private EnumCategoriaModeloVeiculo categoria;
    private EnumTipoCombustivel combustivel;
}
