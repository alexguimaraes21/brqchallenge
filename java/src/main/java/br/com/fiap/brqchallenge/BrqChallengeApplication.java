package br.com.fiap.brqchallenge;

import br.com.fiap.brqchallenge.beans.*;
import br.com.fiap.brqchallenge.enums.EnumTipoTelefone;
import br.com.fiap.brqchallenge.models.Endereco;
import br.com.fiap.brqchallenge.models.Telefone;
import br.com.fiap.brqchallenge.models.Usuario;
import br.com.fiap.brqchallenge.repositories.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
        UsuarioBean usuarioBean = new UsuarioBean(usuarioRepository, pessoaRepository, telefoneRepository, enderecoRepository);

        /*
         * Iniciando os cadastros utilizando as regras aplicadas nos Beans de Negócio
         */
        // TODO: Implementar os cadastros

        // Usuario: String dsEmail, String dsSenha, String nmPessoa, String tipoPessoa, List<Telefone> telefones
        int opcaoMenu = 100;

        while (opcaoMenu != 99) {
            System.out.println("### MENU ###");
            System.out.println("Para sair, entre com a opção 99");
            System.out.println("Para cadastrar um usuário, entre com a opção 1");
            System.out.println("Para listar um usuário, entre com a opção 2");
            System.out.println("Para listar todos os usuários, entre com a opção 3");
            System.out.println("Para editar um usuário, entre com a opção 4");
            Scanner scanner = new Scanner(System.in);
            try {
                opcaoMenu = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
//                System.out.println("Opção inválida");
            }
            switch (opcaoMenu) {
                case 1: // cadastrar um usuário
                    List<Telefone> telefones = new ArrayList<>();

                    // Usuário e Pessoa
                    System.out.println("Digite o endereço de e-mail: ");
                    String dsEmail = scanner.nextLine();
                    System.out.println("Digite a senha: ");
                    String dsSenha = scanner.nextLine();
                    System.out.println("Digite seu Nome: ");
                    String nmPessoa = scanner.nextLine();
                    System.out.println("Digite se é 'PJ' para Pessoa Jurídica ou 'PF' para Pessoa Física: ");
                    String tipoPessoa = scanner.nextLine();
                    System.out.println("Digite o ddd do telefone fixo: ");
                    String dddTelefone1 = scanner.nextLine();
                    System.out.println("Digite o telefone fixo: ");

                    // Telefone Fixo
                    String numeroTelefone1 = scanner.nextLine();
                    Telefone telefoneFixo = new Telefone();
                    telefoneFixo.setNrTelefone(numeroTelefone1);
                    telefoneFixo.setNrDdd(dddTelefone1);
                    telefoneFixo.setTipoTelefone(EnumTipoTelefone.FIXO);
                    telefones.add(telefoneFixo);

                    // Telefone Celular
                    System.out.println("Digite o ddd do telefone celular: ");
                    String dddTelefone2 = scanner.nextLine();
                    System.out.println("Digite o telefone celular: ");
                    String numeroTelefone2 = scanner.nextLine();
                    Telefone telefoneCel = new Telefone();
                    telefoneCel.setNrTelefone(numeroTelefone2);
                    telefoneCel.setNrDdd(dddTelefone2);
                    telefoneCel.setTipoTelefone(EnumTipoTelefone.CELULAR);
                    telefones.add(telefoneCel);

                    // Endereço
                    System.out.println("Digite o tipo do logradouro (RUA, AVENIDA, TRAVESSA, PRACA, RODOVIA):");
                    String tipoLogradouro = scanner.nextLine();
                    System.out.println("Digite o nome do logradouro:");
                    String nmLogradouro = scanner.nextLine();
                    System.out.println("Digite o número do logradouro:");
                    String nrLogradouro = scanner.nextLine();
                    System.out.println("Digite o complemento ou deixe vazio caso não tenha:");
                    String nmComplemento = scanner.nextLine();
                    System.out.println("Digite o CEP:");
                    String nrCep = scanner.nextLine();
                    System.out.println("Digite o bairro");
                    String nmBairro = scanner.nextLine();
                    System.out.println("Digite o munícipio");
                    String nmMunicipio = scanner.nextLine();
                    System.out.println("Digite o estado. Exemplo: SP, MG, RJ:");
                    String estado = scanner.nextLine();
                    usuarioBean.cadastrar(dsEmail, dsSenha, nmPessoa, tipoPessoa, telefones, nmLogradouro, tipoLogradouro,
                            Integer.parseInt(nrLogradouro), nmComplemento, nrCep, nmBairro, nmMunicipio, estado);
                    break;
                case 2: // listar um usuário
                    System.out.println("Digite o ID do usuario: ");
                    String idUsuario = scanner.nextLine();
                    Optional<Usuario> usuario = usuarioBean.buscarPorId(Long.parseLong(idUsuario));
                    if (usuario.isPresent()) {
                        System.out.println("Usuário com ID: [ " + idUsuario + " ]");
                        System.out.println("Nome: [ " + usuario.get().getPessoa().getNmPessoa() + " ]");
                        System.out.println("E-mail: [ " + usuario.get().getDsEmail() + " ]");
                        System.out.println("Cadastrado em: [ " + usuario.get().getDtHrCadastro() + " ]");
                        for (Telefone telefone: usuario.get().getPessoa().getTelefones()) {
                            switch (telefone.getTipoTelefone()) {
                                case FIXO:
                                    System.out.println("  Tipo Telefone: [ " + telefone.getTipoTelefone() + " ]");
                                    System.out.println("    DDD do Telefone Fixo: [ " + telefone.getNrDdd() + " ]");
                                    System.out.println("    Número do Telefone Fixo: [ " + telefone.getNrTelefone() + " ]");
                                    break;
                                case CELULAR:
                                    System.out.println("  Tipo Telefone: [ " + telefone.getTipoTelefone() + " ]");
                                    System.out.println("    DDD do Telefone Celular: [ " + telefone.getNrDdd() + " ]");
                                    System.out.println("    Número do Telefone Celular: [ " + telefone.getNrTelefone() + " ]");
                                    break;
                                case COMERCIAL:
                                    System.out.println("  Tipo Telefone: [ " + telefone.getTipoTelefone() + " ]");
                                    System.out.println("    DDD do Telefone Comercial: [ " + telefone.getNrDdd() + " ]");
                                    System.out.println("    Número do Telefone Comercial: [ " + telefone.getNrTelefone() + " ]");
                                    break;
                            }
                        }
                        System.out.println("  Endereço: RESIDENCIAL");
                        System.out.println("    Tipo do Logradouro: [ " + usuario.get().getPessoa().getResidencial().getTipoLogradouro() + " ]");
                        System.out.println("    Logradouro: [ " + usuario.get().getPessoa().getResidencial().getNmLogradouro() + " ]");
                        System.out.println("    Número: [ " + usuario.get().getPessoa().getResidencial().getNrLogradouro() + " ]");
                        System.out.println("    Complemento: [ " + usuario.get().getPessoa().getResidencial().getNmComplemento() + " ]");
                        System.out.println("    CEP: [ " + usuario.get().getPessoa().getResidencial().getNrCep() + " ]");
                        System.out.println("    Bairro: [ " + usuario.get().getPessoa().getResidencial().getNmBairro() + " ]");
                        System.out.println("    Município: [ " + usuario.get().getPessoa().getResidencial().getNmMunicipio() + " ]");
                        System.out.println("    UF: [ " + usuario.get().getPessoa().getResidencial().getNmEstado() + " ]");
                    } else {
                        System.out.println("Usuário não encontrado!");
                    }
                    break;
                case 3: // listar todos os usuários
                    List<Usuario> usuarios = usuarioBean.listarTodos();
                    if ( null != usuarios ) {
                        for (Usuario usuarioCadastrado : usuarios) {
                            System.out.println("Usuário com ID: [ " + usuarioCadastrado.getId() + " ]");
                            System.out.println("Nome: [ " + usuarioCadastrado.getPessoa().getNmPessoa() + " ]");
                            System.out.println("E-mail: [ " + usuarioCadastrado.getDsEmail() + " ]");
                            System.out.println("Cadastrado em: [ " + usuarioCadastrado.getDtHrCadastro() + " ]");
                            for (Telefone telefoneUsuario: usuarioCadastrado.getPessoa().getTelefones()) {
                                switch (telefoneUsuario.getTipoTelefone()) {
                                    case FIXO:
                                        System.out.println("  Tipo Telefone: [ " + telefoneUsuario.getTipoTelefone() + " ]");
                                        System.out.println("    DDD do Telefone Fixo: [ " + telefoneUsuario.getNrDdd() + " ]");
                                        System.out.println("    Número do Telefone Fixo: [ " + telefoneUsuario.getNrTelefone() + " ]");
                                        break;
                                    case CELULAR:
                                        System.out.println("  Tipo Telefone: [ " + telefoneUsuario.getTipoTelefone() + " ]");
                                        System.out.println("    DDD do Telefone Celular: [ " + telefoneUsuario.getNrDdd() + " ]");
                                        System.out.println("    Número do Telefone Celular: [ " + telefoneUsuario.getNrTelefone() + " ]");
                                        break;
                                    case COMERCIAL:
                                        System.out.println("  Tipo Telefone: [ " + telefoneUsuario.getTipoTelefone() + " ]");
                                        System.out.println("    DDD do Telefone Comercial: [ " + telefoneUsuario.getNrDdd() + " ]");
                                        System.out.println("    Número do Telefone Comercial: [ " + telefoneUsuario.getNrTelefone() + " ]");
                                        break;
                                }
                            }
                            System.out.println("  Endereço: RESIDENCIAL");
                            System.out.println("    Tipo do Logradouro: [ " + usuarioCadastrado.getPessoa().getResidencial().getTipoLogradouro() + " ]");
                            System.out.println("    Logradouro: [ " + usuarioCadastrado.getPessoa().getResidencial().getNmLogradouro() + " ]");
                            System.out.println("    Número: [ " + usuarioCadastrado.getPessoa().getResidencial().getNrLogradouro() + " ]");
                            System.out.println("    Complemento: [ " + usuarioCadastrado.getPessoa().getResidencial().getNmComplemento() + " ]");
                            System.out.println("    CEP: [ " + usuarioCadastrado.getPessoa().getResidencial().getNrCep() + " ]");
                            System.out.println("    Bairro: [ " + usuarioCadastrado.getPessoa().getResidencial().getNmBairro() + " ]");
                            System.out.println("    Município: [ " + usuarioCadastrado.getPessoa().getResidencial().getNmMunicipio() + " ]");
                            System.out.println("    UF: [ " + usuarioCadastrado.getPessoa().getResidencial().getNmEstado() + " ]");
                        }
                    } else {
                        System.out.println("Nenhum usuário cadastrado!");
                    }
                    break;
                case 4: //editar um usuário
                    System.out.println("Digite o ID do usuário que deseja editar: ");
                    String idUsuarioEditar = scanner.nextLine();
                    System.out.println("Digite o ID do usuário que deseja editar: ");
                    String dsEmailEditar = scanner.nextLine();
                    System.out.println("Digite o ID do usuário que deseja editar: ");
                    String dsSenhaEditar = scanner.nextLine();
                    System.out.println("Digite o ID do usuário que deseja editar: ");
                    String nmPessoaEditar = scanner.nextLine();
                    System.out.println("Digite o ID do usuário que deseja editar: ");
                    String tipoPessoaEditar = scanner.nextLine();
                    usuarioBean.editar(Long.parseLong(idUsuarioEditar), dsEmailEditar, dsSenhaEditar, nmPessoaEditar, tipoPessoaEditar, telefones);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
