package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Pessoa;

import java.util.List;

public class PessoaRepository extends AbstractRepository<Pessoa> {

    private long id;
    @Override
    public void cadastrar(Pessoa obj) {
        List<Pessoa> objs = this.buscarTodos();
        long lastId = 0;
        for (Pessoa lastObjCadastrado: objs) {
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
