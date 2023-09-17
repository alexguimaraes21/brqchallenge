package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.repositories.LocacaoRepository;

public class LocacaoBean {

    LocacaoRepository locacaoRepository;

    public LocacaoBean(LocacaoRepository repository) {
        this.locacaoRepository = repository;
    }
}
