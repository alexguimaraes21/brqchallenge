package br.com.fiap.brqchallenge.repositories;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<T> implements BasicOperation {

    private List<Object> objects;

    @Override
    public void cadastrar(Object o) {
        this.objects.add(o);
    }

    @Override
    public void editar(long id, Object o) throws NoSuchFieldException {

    }

    @Override
    public Optional detalhes(long id) {
        return Optional.empty();
    }
}
