package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.repositories.PagamentoRepository;

public class PagamentoBean {

    PagamentoRepository pagamentoRepository;

    public PagamentoBean(PagamentoRepository repository) {
        this.pagamentoRepository = repository;
    }
}
