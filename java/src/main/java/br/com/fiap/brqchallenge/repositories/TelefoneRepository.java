package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Telefone;

import java.util.ArrayList;
import java.util.List;

public class TelefoneRepository extends AbstractRepository<Telefone> {

    private long id;

    public TelefoneRepository() { super.objects = new ArrayList<>(); }
    @Override
    public void cadastrar(Telefone obj) {
        List<Telefone> objs = this.buscarTodos();
        long lastId = 0;
        if( null != objs ) {
            for (Telefone lastObjCadastrado : objs) {
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
