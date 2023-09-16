package br.com.fiap.brqchallenge.repositories;

import java.util.Optional;

public interface BasicOperation<T> {

	void cadastrar(T t);
	void editar(long id, T t) throws NoSuchFieldException;
	Optional<T> detalhes(long id);
}
