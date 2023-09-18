package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Marca;

import java.util.ArrayList;
import java.util.List;

public class MarcaRepository extends AbstractRepository<Marca> {

    private long id;

    public MarcaRepository() { super.objects = new ArrayList<>(); }
    @Override
    public void cadastrar(Marca obj) {
        List<Marca> objs = this.buscarTodos();
        long lastId = 0;
        if( null != objs ) {
            for (Marca lastObjCadastrado : objs) {
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
