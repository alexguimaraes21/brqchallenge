package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Telefone;

import java.util.List;

public class TelefoneRepository extends AbstractRepository<Telefone> {

    private long id;
    @Override
    public void cadastrar(Telefone obj) {
        List<Telefone> objs = this.buscarTodos();
        long lastId = 0;
        for (Telefone lastObjCadastrado: objs) {
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
