package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.enums.EnumCategoriaModeloVeiculo;
import br.com.fiap.brqchallenge.enums.EnumTipoCombustivel;
import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Marca;
import br.com.fiap.brqchallenge.models.Modelo;
import br.com.fiap.brqchallenge.repositories.AcessorioRepository;
import br.com.fiap.brqchallenge.repositories.MarcaRepository;
import br.com.fiap.brqchallenge.repositories.ModeloRepository;

import java.util.List;
import java.util.Optional;

public class ModeloBean {

    ModeloRepository modeloRepository;
    MarcaRepository marcaRepository;

    public ModeloBean(ModeloRepository repository) {
        this.modeloRepository = repository;
    }

    public ModeloBean(ModeloRepository repository, MarcaRepository marcaRepository) {
        this.modeloRepository = repository;
        this.marcaRepository = marcaRepository;
    }

    public void cadastrar(String nmModelo, String nmCor, int nrPortas, String dsPlaca, String dsRenavam, String dsChassi,
                          String nmPaisOrigem, long marcaId, String categoria, String combustivel,
                          double vlAluguelHora, double vlAluguelDiaria, double vlAluguelMensal) {
        Optional<Marca> marca = marcaRepository.buscarPorId(obj -> obj.getId() == marcaId);
        if (marca.isPresent()) {
            Modelo modelo = new Modelo();
            modelo.setNmModelo(nmModelo);
            modelo.setNmCor(nmCor);
            modelo.setNrPortas(nrPortas);
            modelo.setDsPlaca(dsPlaca);
            modelo.setDsRenavam(dsRenavam);
            modelo.setDsChassi(dsChassi);
            modelo.setNmPaisOrigem(nmPaisOrigem);
            modelo.setMarca(marca.get());
            modelo.setCombustivel(EnumTipoCombustivel.valueOf(combustivel.toLowerCase().toUpperCase()));
            modelo.setVlAluguelHora(vlAluguelHora);
            modelo.setVlAluguelDiaria(vlAluguelDiaria);
            modelo.setVlAluguelMensal(vlAluguelMensal);
            modelo.setCategoria(EnumCategoriaModeloVeiculo.valueOf(categoria.toLowerCase().toUpperCase()));
            modeloRepository.cadastrar(modelo);
        } else {
            System.out.println("Marca não encontrada!");
        }
    }

    public Optional<Modelo> buscarPorId(long id) {
        return modeloRepository.buscarPorId(obj -> obj.getId() == id);
    }

    public List<Modelo> listarTodos() {
        return modeloRepository.buscarTodos();
    }

    public void editar(long id, String nmAcessorio, String dsAcessorio, double vlAcessorioHora, double vlAcessorioDiaria, double vlAcessorioMensal) {
        Optional<Modelo> modelo = this.buscarPorId(id);
        if (modelo.isPresent()) {
        }
    }
}
