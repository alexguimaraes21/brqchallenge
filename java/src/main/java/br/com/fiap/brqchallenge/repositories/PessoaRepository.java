package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository extends AbstractRepository<Pessoa> {

    private long id;

    public PessoaRepository() { super.objects = new ArrayList<>(); }
    @Override
    public void cadastrar(Pessoa obj) {
        List<Pessoa> objs = this.buscarTodos();
        long lastId = 0;
        if( null != objs ) {
            for (Pessoa lastObjCadastrado : objs) {
                lastId = lastObjCadastrado.getId();
            }
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
