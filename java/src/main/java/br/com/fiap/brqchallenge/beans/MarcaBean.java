package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Marca;
import br.com.fiap.brqchallenge.models.Usuario;
import br.com.fiap.brqchallenge.repositories.AcessorioRepository;
import br.com.fiap.brqchallenge.repositories.MarcaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class MarcaBean {

    MarcaRepository marcaRepository;

    public MarcaBean(MarcaRepository repository) {
        this.marcaRepository = repository;
    }

    public void cadastrar(String nmMarca) {
        Marca marca = new Marca();
        marca.setNmMarca(nmMarca);
        marcaRepository.cadastrar(marca);
    }

    public Optional<Marca> buscarPorId(long id) {
        return marcaRepository.buscarPorId(obj -> obj.getId() == id);
    }

    public List<Marca> listarTodos() {
        return marcaRepository.buscarTodos();
    }

    public void editar(long id, String nmMarca) {
        Optional<Marca> marca = this.buscarPorId(id);
        if (marca.isPresent()) {
            marca.get().setNmMarca(nmMarca);
            marca.get().setAtualizadoEm(LocalDateTime.now());
            marcaRepository.atualizar(obj -> obj.getId() == id, marca.get());
        }
    }
}
