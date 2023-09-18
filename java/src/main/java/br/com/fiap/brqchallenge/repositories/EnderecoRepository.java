package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Endereco;

import java.util.ArrayList;
import java.util.List;

public class EnderecoRepository extends AbstractRepository<Endereco> {

    private long id;

    public EnderecoRepository() { super.objects = new ArrayList<>(); }
    @Override
    public void cadastrar(Endereco obj) {
        List<Endereco> objs = this.buscarTodos();
        long lastId = 0;
        if( null != objs ) {
            for (Endereco lastObjCadastrado : objs) {
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
