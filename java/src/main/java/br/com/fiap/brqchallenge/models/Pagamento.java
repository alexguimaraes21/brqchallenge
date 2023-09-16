package br.com.fiap.brqchallenge.models;

import br.com.fiap.brqchallenge.enums.EnumTipoCartao;
import br.com.fiap.brqchallenge.enums.EnumTipoPagamento;

public class Pagamento {

    private Pessoa pessoa;
    private double vlLocacao;
    private double vlDesconto;
    private EnumTipoPagamento tipoPagamento;
    private String nrCartao;
    private String nmBandeiraCartao;
    private EnumTipoCartao tipoCartao;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getVlLocacao() {
        return vlLocacao;
    }

    public void setVlLocacao(double vlLocacao) {
        this.vlLocacao = vlLocacao;
    }

    public double getVlDesconto() {
        return vlDesconto;
    }

    public void setVlDesconto(double vlDesconto) {
        this.vlDesconto = vlDesconto;
    }

    public EnumTipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(EnumTipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getNrCartao() {
        return nrCartao;
    }

    public void setNrCartao(String nrCartao) {
        this.nrCartao = nrCartao;
    }

    public String getNmBandeiraCartao() {
        return nmBandeiraCartao;
    }

    public void setNmBandeiraCartao(String nmBandeiraCartao) {
        this.nmBandeiraCartao = nmBandeiraCartao;
    }

    public EnumTipoCartao getTipoCartao() {
        return tipoCartao;
    }

    public void setTipoCartao(EnumTipoCartao tipoCartao) {
        this.tipoCartao = tipoCartao;
    }
}
