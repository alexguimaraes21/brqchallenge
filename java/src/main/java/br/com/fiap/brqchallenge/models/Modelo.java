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
    private double vlAluguelHora;
    private double vlAluguelDiaria;
    private double vlAluguelMensal;

    public String getNmModelo() {
        return nmModelo;
    }

    public void setNmModelo(String nmModelo) {
        this.nmModelo = nmModelo;
    }

    public String getNmCor() {
        return nmCor;
    }

    public void setNmCor(String nmCor) {
        this.nmCor = nmCor;
    }

    public int getNrPortas() {
        return nrPortas;
    }

    public void setNrPortas(int nrPortas) {
        this.nrPortas = nrPortas;
    }

    public String getDsPlaca() {
        return dsPlaca;
    }

    public void setDsPlaca(String dsPlaca) {
        this.dsPlaca = dsPlaca;
    }

    public String getDsRenavam() {
        return dsRenavam;
    }

    public void setDsRenavam(String dsRenavam) {
        this.dsRenavam = dsRenavam;
    }

    public String getDsChassi() {
        return dsChassi;
    }

    public void setDsChassi(String dsChassi) {
        this.dsChassi = dsChassi;
    }

    public String getNmPaisOrigem() {
        return nmPaisOrigem;
    }

    public void setNmPaisOrigem(String nmPaisOrigem) {
        this.nmPaisOrigem = nmPaisOrigem;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public EnumCategoriaModeloVeiculo getCategoria() {
        return categoria;
    }

    public void setCategoria(EnumCategoriaModeloVeiculo categoria) {
        this.categoria = categoria;
    }

    public EnumTipoCombustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(EnumTipoCombustivel combustivel) {
        this.combustivel = combustivel;
    }

    public double getVlAluguelHora() {
        return vlAluguelHora;
    }

    public void setVlAluguelHora(double vlAluguelHora) {
        this.vlAluguelHora = vlAluguelHora;
    }

    public double getVlAluguelDiaria() {
        return vlAluguelDiaria;
    }

    public void setVlAluguelDiaria(double vlAluguelDiaria) {
        this.vlAluguelDiaria = vlAluguelDiaria;
    }

    public double getVlAluguelMensal() {
        return vlAluguelMensal;
    }

    public void setVlAluguelMensal(double vlAluguelMensal) {
        this.vlAluguelMensal = vlAluguelMensal;
    }
}
