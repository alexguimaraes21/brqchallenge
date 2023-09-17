package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Modelo;

import java.util.List;

public class ModeloRepository extends AbstractRepository<Modelo>{

    private long id;

    @Override
    public void cadastrar(Modelo obj) {
        List<Modelo> objs = this.buscarTodos();
        long lastId = 0;
        for (Modelo lastObjCadastrado: objs) {
            lastId = lastObjCadastrado.getId();
        }
        obj.setId(lastId + 1);
        this.id = lastId;
        super.cadastrar(obj);
    }

    @Override
    public long getId() {
        return this.id;
    }
}
