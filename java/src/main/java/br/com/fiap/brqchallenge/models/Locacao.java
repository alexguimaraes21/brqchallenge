package br.com.fiap.brqchallenge.models;

import br.com.fiap.brqchallenge.enums.EnumTipoCartao;
import br.com.fiap.brqchallenge.enums.EnumTipoLocacao;
import br.com.fiap.brqchallenge.enums.EnumTipoPagamento;

import java.time.LocalDateTime;

public class Locacao {

    private long id;
    private LocalDateTime dtHrLocacao;
    private LocalDateTime dtHrRetirada;
    private LocalDateTime dtHrDevolucao;
    private EnumTipoLocacao tipoLocacao;
    private Pessoa pessoa;
    private double vlLocacao;
    private double vlDesconto;
    private EnumTipoPagamento tipoPagamento;
    private String nrCartao;
    private String nmBandeiraCartao;
    private EnumTipoCartao tipoCartao;
    private Modelo veiculo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDtHrLocacao() {
        return dtHrLocacao;
    }

    public void setDtHrLocacao(LocalDateTime dtHrLocacao) {
        this.dtHrLocacao = dtHrLocacao;
    }

    public LocalDateTime getDtHrRetirada() {
        return dtHrRetirada;
    }

    public void setDtHrRetirada(LocalDateTime dtHrRetirada) {
        this.dtHrRetirada = dtHrRetirada;
    }

    public LocalDateTime getDtHrDevolucao() {
        return dtHrDevolucao;
    }

    public void setDtHrDevolucao(LocalDateTime dtHrDevolucao) {
        this.dtHrDevolucao = dtHrDevolucao;
    }

    public EnumTipoLocacao getTipoLocacao() {
        return tipoLocacao;
    }

    public void setTipoLocacao(EnumTipoLocacao tipoLocacao) {
        this.tipoLocacao = tipoLocacao;
    }

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

    public Modelo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Modelo veiculo) {
        this.veiculo = veiculo;
    }
}
