package br.com.fiap.brqchallenge;

import br.com.fiap.brqchallenge.beans.*;
import br.com.fiap.brqchallenge.repositories.*;

public class BrqChallengeApplication {

    public static void main(String[] args) {

        /*
         * Inicializando os Repositórios
         */
        AcessorioRepository acessorioRepository = new AcessorioRepository();
        ArquivoRepository arquivoRepository = new ArquivoRepository();
        DocumentoRepository documentoRepository = new DocumentoRepository();
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        LocacaoRepository locacaoRepository = new LocacaoRepository();
        MarcaRepository marcaRepository = new MarcaRepository();
        ModeloRepository modeloRepository = new ModeloRepository();
        PagamentoRepository pagamentoRepository = new PagamentoRepository();
        PessoaRepository pessoaRepository = new PessoaRepository();
        TelefoneRepository telefoneRepository = new TelefoneRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        /*
         * Inicializando os Beans para testar as classes
         */
        AcessorioBean acessorioBean = new AcessorioBean(acessorioRepository);
        ArquivoBean arquivoBean = new ArquivoBean(arquivoRepository);
        DocumentoBean documentoBean = new DocumentoBean(documentoRepository);
        EnderecoBean enderecoBean = new EnderecoBean(enderecoRepository);
        LocacaoBean locacaoBean = new LocacaoBean(locacaoRepository);
        MarcaBean marcaBean = new MarcaBean(marcaRepository);
        ModeloBean modeloBean = new ModeloBean(modeloRepository);
        PagamentoBean pagamentoBean = new PagamentoBean(pagamentoRepository);
        PessoaBean pessoaBean = new PessoaBean(pessoaRepository);
        TelefoneBean telefoneBean = new TelefoneBean(telefoneRepository);
        UsuarioBean usuarioBean = new UsuarioBean(usuarioRepository, pessoaRepository, telefoneRepository);

        /*
         * Iniciando os cadastros utilizando as regras aplicadas nos Beans de Negócio
         */
        // TODO: Implementar os cadastros

        // Usuario: String dsEmail, String dsSenha, String nmPessoa, String tipoPessoa, List<Telefone> telefones


    }
}
