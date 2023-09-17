package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Marca;

import java.util.List;

public class MarcaRepository extends AbstractRepository<Marca> {

    private long id;
    @Override
    public void cadastrar(Marca obj) {
        List<Marca> objs = this.buscarTodos();
        long lastId = 0;
        for (Marca lastObjCadastrado: objs) {
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
