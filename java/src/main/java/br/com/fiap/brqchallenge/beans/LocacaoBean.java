package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.enums.EnumTipoCartao;
import br.com.fiap.brqchallenge.enums.EnumTipoLocacao;
import br.com.fiap.brqchallenge.enums.EnumTipoPagamento;
import br.com.fiap.brqchallenge.models.Locacao;
import br.com.fiap.brqchallenge.models.Modelo;
import br.com.fiap.brqchallenge.models.Pessoa;
import br.com.fiap.brqchallenge.repositories.LocacaoRepository;
import br.com.fiap.brqchallenge.repositories.ModeloRepository;
import br.com.fiap.brqchallenge.repositories.PessoaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class LocacaoBean {

    LocacaoRepository locacaoRepository;
    PessoaRepository pessoaRepository;
    ModeloRepository modeloRepository;

    public LocacaoBean(LocacaoRepository repository) {
        this.locacaoRepository = repository;
    }

    public LocacaoBean(LocacaoRepository locacaoRepository, PessoaRepository pessoaRepository, ModeloRepository modeloRepository) {
        this.locacaoRepository = locacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.modeloRepository = modeloRepository;
    }

    public void alugar(LocalDateTime dtHrRetirada, LocalDateTime dtHrDevolucao, String tipoLocacao, long idPessoa,
                       double vlLocacao, double vlDesconto, String tipoPagamento, String nrCartao, String nmBandeiraCartao,
                       long idVeiculo) {
        Optional<Pessoa> pessoa = this.pessoaRepository.buscarPorId(pes -> pes.getId() == idPessoa);
        Optional<Modelo> veiculo = this.modeloRepository.buscarPorId(mod -> mod.getId() == idVeiculo);
        if(pessoa.isEmpty() || veiculo.isEmpty()) {
            System.out.println("Dados inválidos. Preencha todas as informações corretamente!");
            return;
        }

        Locacao locacao = new Locacao();
        locacao.setDtHrLocacao(LocalDateTime.now());
        locacao.setDtHrRetirada(dtHrRetirada);
        locacao.setDtHrDevolucao(dtHrDevolucao);
        locacao.setTipoLocacao(EnumTipoLocacao.valueOf(tipoLocacao.toLowerCase().toUpperCase()));
        locacao.setVlLocacao(vlLocacao);
        if (vlDesconto > 0.0) {
            locacao.setVlDesconto(vlDesconto);
        }
        locacao.setTipoPagamento(EnumTipoPagamento.valueOf(tipoPagamento.toLowerCase().toUpperCase()));
        if (locacao.getTipoPagamento().equals(EnumTipoPagamento.CARTAODEBITO)) {
            locacao.setTipoCartao(EnumTipoCartao.DEBITO);
            locacao.setNrCartao(nrCartao);
            locacao.setNmBandeiraCartao(nmBandeiraCartao);
        } else if (locacao.getTipoPagamento().equals(EnumTipoPagamento.CARTAOCREDITO)) {
            locacao.setTipoCartao(EnumTipoCartao.CREDITO);
            locacao.setNrCartao(nrCartao);
            locacao.setNmBandeiraCartao(nmBandeiraCartao);
        }
        locacao.setPessoa(pessoa.get());
        locacao.setVeiculo(veiculo.get());

        locacaoRepository.cadastrar(locacao);
    }
}
