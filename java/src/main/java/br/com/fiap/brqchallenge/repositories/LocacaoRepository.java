package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Locacao;

import java.util.ArrayList;
import java.util.List;

public class LocacaoRepository extends AbstractRepository<Locacao> {

    private long id;

    public LocacaoRepository() { super.objects = new ArrayList<>(); }
    @Override
    public void cadastrar(Locacao obj) {
        List<Locacao> objs = this.buscarTodos();
        long lastId = 0;
        if( null != objs ) {
            for (Locacao lastObjCadastrado : objs) {
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
