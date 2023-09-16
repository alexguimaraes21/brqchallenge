package br.com.fiap.brqchallenge.models;

import br.com.fiap.brqchallenge.enums.EnumTipoLocacao;
import br.com.fiap.brqchallenge.enums.EnumTipoPagamento;

import java.time.LocalDateTime;

public class Locacao {

    private long id;
    private LocalDateTime dtHrLocacao;
    private LocalDateTime dtHrDevolucao;
    private Pagamento pagamento;
    private EnumTipoLocacao tipoLocacao;

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

    public LocalDateTime getDtHrDevolucao() {
        return dtHrDevolucao;
    }

    public void setDtHrDevolucao(LocalDateTime dtHrDevolucao) {
        this.dtHrDevolucao = dtHrDevolucao;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public EnumTipoLocacao getTipoLocacao() {
        return tipoLocacao;
    }

    public void setTipoLocacao(EnumTipoLocacao tipoLocacao) {
        this.tipoLocacao = tipoLocacao;
    }
}
