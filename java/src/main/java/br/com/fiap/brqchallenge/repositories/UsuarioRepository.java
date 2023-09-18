package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository extends AbstractRepository<Usuario> {

    private long id;

    public UsuarioRepository() { super.objects = new ArrayList<>(); }

    @Override
    public void cadastrar(Usuario obj) {
        List<Usuario> objs = this.buscarTodos();
        long lastId = 0;
        if( null != objs ) {
            for (Usuario usuarioCadastrado : objs) {
                lastId = usuarioCadastrado.getId();
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
