package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class PagamentoRepository extends AbstractRepository<Pagamento> {

    private long id;

    public PagamentoRepository() { super.objects = new ArrayList<>(); }
    @Override
    public void cadastrar(Pagamento obj) {
        List<Pagamento> objs = this.buscarTodos();
        long lastId = 0;
        if( null != objs ) {
            for (Pagamento lastObjCadastrado : objs) {
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
