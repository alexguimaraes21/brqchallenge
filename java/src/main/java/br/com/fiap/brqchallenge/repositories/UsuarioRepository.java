package br.com.fiap.brqchallenge.repositories;

import br.com.fiap.brqchallenge.models.Usuario;

import java.util.List;

public class UsuarioRepository extends AbstractRepository<Usuario> {

    private long id;

    @Override
    public void cadastrar(Usuario usuario) {
        List<Usuario> usuarios = this.buscarTodos();
        long lastId = 0;
        for (Usuario usuarioCadastrado: usuarios) {
            lastId = usuarioCadastrado.getId();
        }
        usuario.setId(lastId + 1);
        this.id = lastId;
        super.cadastrar(usuario);
    }

    @Override
    public long getId() {
        return this.id;
    }
}
