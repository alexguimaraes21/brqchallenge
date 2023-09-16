package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.repositories.AcessorioRepository;

public class AcessorioBean {

    public void cadastrarAcessorio(String nmAcessorio, String dsAcessorio, double vlAcessorioHora, double vlAcessorioDiaria, double vlAcessorioMensal) {
        AcessorioRepository acessorioRepository = new AcessorioRepository();
        Acessorio acessorio = new Acessorio();
        acessorio.setNmAcessorio(nmAcessorio);
        acessorio.setDsAcessorio(dsAcessorio);
        acessorio.setVlAcessorioHora(vlAcessorioHora);
        acessorio.setVlAcessorioDiaria(vlAcessorioDiaria);
        acessorio.setVlAcessorioMensal(vlAcessorioMensal);
        acessorioRepository.cadastrar(acessorio);
    }

    public void editarAcessorio(long id, String nmAcessorio, String dsAcessorio, double vlAcessorioHora, double vlAcessorioDiaria, double vlAcessorioMensal) {
        AcessorioRepository acessorioRepository = new AcessorioRepository();
    }
}
