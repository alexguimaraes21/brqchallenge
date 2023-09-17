package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Documento;

import java.util.List;

public class DocumentoRepository extends AbstractRepository<Documento> {
    private long id;
    @Override
    public void cadastrar(Documento obj) {
        List<Documento> objs = this.buscarTodos();
        long lastId = 0;
        for (Documento lastObjCadastrado: objs) {
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
