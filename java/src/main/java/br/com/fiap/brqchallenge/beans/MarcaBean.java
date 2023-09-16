package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.repositories.AcessorioRepository;

import java.util.List;
import java.util.Optional;

public class MarcaBean {

    public void cadastrar(String nmAcessorio, String dsAcessorio, double vlAcessorioHora, double vlAcessorioDiaria, double vlAcessorioMensal) {
        AcessorioRepository acessorioRepository = new AcessorioRepository();
        Acessorio acessorio = new Acessorio();
        acessorio.setNmAcessorio(nmAcessorio);
        acessorio.setDsAcessorio(dsAcessorio);
        acessorio.setVlAcessorioHora(vlAcessorioHora);
        acessorio.setVlAcessorioDiaria(vlAcessorioDiaria);
        acessorio.setVlAcessorioMensal(vlAcessorioMensal);
        acessorioRepository.cadastrar(acessorio);
    }

    public Optional<Acessorio> buscarPorId(long id) {
        AcessorioRepository acessorioRepository = new AcessorioRepository();
        return acessorioRepository.buscarPorId(obj -> obj.getId() == id);
    }

    public List<Acessorio> listarTodos() {
        AcessorioRepository acessorioRepository = new AcessorioRepository();
        return acessorioRepository.buscarTodos();
    }

    public void editar(long id, String nmAcessorio, String dsAcessorio, double vlAcessorioHora, double vlAcessorioDiaria, double vlAcessorioMensal) {
        AcessorioRepository acessorioRepository = new AcessorioRepository();
        Optional<Acessorio> acessorio = this.buscarPorId(id);
        if (acessorio.isPresent()) {
            acessorio.get().setNmAcessorio(nmAcessorio);
            acessorio.get().setDsAcessorio(dsAcessorio);
            acessorio.get().setVlAcessorioHora(vlAcessorioHora);
            acessorio.get().setVlAcessorioDiaria(vlAcessorioDiaria);
            acessorio.get().setVlAcessorioMensal(vlAcessorioMensal);
            acessorioRepository.atualizar(obj -> obj.getId() == id, acessorio.get());
        }
    }
}
