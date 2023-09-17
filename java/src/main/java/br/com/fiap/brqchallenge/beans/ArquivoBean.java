package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.repositories.ArquivoRepository;

public class ArquivoBean {

    ArquivoRepository arquivoRepository;

    public ArquivoBean(ArquivoRepository repository) {
        this.arquivoRepository = repository;
    }
}
