package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.repositories.DocumentoRepository;

public class DocumentoBean {

    DocumentoRepository documentoRepository;

    public DocumentoBean(DocumentoRepository repository) {
        this.documentoRepository = repository;
    }
}
