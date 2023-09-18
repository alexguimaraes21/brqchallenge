package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class AcessorioRepository extends AbstractRepository<Acessorio> {

    private long id;

    public AcessorioRepository() { super.objects = new ArrayList<>(); }
    @Override
    public void cadastrar(Acessorio obj) {
        List<Acessorio> objs = this.buscarTodos();
        long lastId = 0;
        if( null != objs ) {
            for (Acessorio lastObjCadastrado : objs) {
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
