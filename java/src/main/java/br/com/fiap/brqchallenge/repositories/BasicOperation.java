package br.com.fiap.brqchallenge.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BasicOperation<T> {

	void cadastrar(T t);
	Optional<T> buscarPorId(Predicate<T> predicate);
	List<T> buscarTodos();
	void atualizar(Predicate<T> predicate, T t);
}
