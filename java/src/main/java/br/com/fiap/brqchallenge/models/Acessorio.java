package br.com.fiap.brqchallenge.models;

public class Acessorio extends AbstractModel {

    private String nmAcessorio;
    private String dsAcessorio;
    private double vlAcessorioHora;
    private double vlAcessorioDiaria;
    private double vlAcessorioMensal;

    public String getNmAcessorio() {
        return nmAcessorio;
    }

    public void setNmAcessorio(String nmAcessorio) {
        this.nmAcessorio = nmAcessorio;
    }

    public String getDsAcessorio() {
        return dsAcessorio;
    }

    public void setDsAcessorio(String dsAcessorio) {
        this.dsAcessorio = dsAcessorio;
    }

    public double getVlAcessorioHora() {
        return vlAcessorioHora;
    }

    public void setVlAcessorioHora(double vlAcessorioHora) {
        this.vlAcessorioHora = vlAcessorioHora;
    }

    public double getVlAcessorioDiaria() {
        return vlAcessorioDiaria;
    }

    public void setVlAcessorioDiaria(double vlAcessorioDiaria) {
        this.vlAcessorioDiaria = vlAcessorioDiaria;
    }

    public double getVlAcessorioMensal() {
        return vlAcessorioMensal;
    }

    public void setVlAcessorioMensal(double vlAcessorioMensal) {
        this.vlAcessorioMensal = vlAcessorioMensal;
    }
}
