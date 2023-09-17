package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.repositories.EnderecoRepository;

public class EnderecoBean {

    EnderecoRepository enderecoRepository;

    public EnderecoBean(EnderecoRepository repository) {
        this.enderecoRepository = repository;
    }
}
