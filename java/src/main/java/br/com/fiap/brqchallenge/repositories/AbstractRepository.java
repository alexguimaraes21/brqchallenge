package br.com.fiap.brqchallenge.repositories;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class AbstractRepository<T> implements BasicOperation<T> {

    protected List<T> objects;

    @Override
    public void cadastrar(T o) {
        this.objects.add(o);
    }

    @Override
    public Optional<T> buscarPorId(Predicate<T> predicate) {
        T t = this.objects.stream().filter(predicate).findFirst().orElse(null);
        if (null != t) {
            return Optional.of(t);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<T> buscarTodos() {
        return this.objects;
    }

    @Override
    public void atualizar(Predicate<T> predicate, T t) {
        T o = this.objects.stream().filter(predicate).findFirst().orElse(null);
        if (null != o) {
            o = t;
        }
    }

    public abstract long getId();
}
