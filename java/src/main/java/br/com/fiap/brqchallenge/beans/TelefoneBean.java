package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.repositories.TelefoneRepository;

public class TelefoneBean {

    TelefoneRepository telefoneRepository;

    public TelefoneBean(TelefoneRepository repository) {
        this.telefoneRepository = repository;
    }
}
