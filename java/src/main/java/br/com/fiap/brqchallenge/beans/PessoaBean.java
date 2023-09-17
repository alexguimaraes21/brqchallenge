package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.repositories.PessoaRepository;

public class PessoaBean {

    PessoaRepository pessoaRepository;

    public PessoaBean(PessoaRepository repository) {
        this.pessoaRepository = repository;
    }
}
