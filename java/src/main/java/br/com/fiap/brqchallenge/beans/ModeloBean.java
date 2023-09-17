package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.enums.EnumCategoriaModeloVeiculo;
import br.com.fiap.brqchallenge.enums.EnumTipoCombustivel;
import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Modelo;
import br.com.fiap.brqchallenge.repositories.AcessorioRepository;
import br.com.fiap.brqchallenge.repositories.ModeloRepository;

import java.util.List;
import java.util.Optional;

public class ModeloBean {

    ModeloRepository modeloRepository;

    public ModeloBean(ModeloRepository repository) {
        this.modeloRepository = repository;
    }

    public void cadastrar(String nmModelo, String nmCor, int nrPortas, String dsPlaca, String dsRenavam, String dsChassi,
                          String nmPaisOrigem, String marca, EnumCategoriaModeloVeiculo categoria, EnumTipoCombustivel combustivel,
                          double vlAluguelHora, double vlAluguelDiaria, double vlAluguelMensal) {
        Modelo modelo = new Modelo();

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
