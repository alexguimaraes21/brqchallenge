package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Arquivo;

import java.util.List;

public class ArquivoRepository extends AbstractRepository<Arquivo> {

    private long id;
    @Override
    public void cadastrar(Arquivo obj) {
        List<Arquivo> objs = this.buscarTodos();
        long lastId = 0;
        for (Arquivo lastObjCadastrado: objs) {
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
