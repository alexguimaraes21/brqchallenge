package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.enums.EnumTipoEstado;
import br.com.fiap.brqchallenge.enums.EnumTipoLogradouro;
import br.com.fiap.brqchallenge.enums.EnumTipoPessoa;
import br.com.fiap.brqchallenge.models.*;
import br.com.fiap.brqchallenge.repositories.EnderecoRepository;
import br.com.fiap.brqchallenge.repositories.PessoaRepository;
import br.com.fiap.brqchallenge.repositories.TelefoneRepository;
import br.com.fiap.brqchallenge.repositories.UsuarioRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

public class UsuarioBean {

    UsuarioRepository usuarioRepository;
    PessoaRepository pessoaRepository;
    TelefoneRepository telefoneRepository;
    EnderecoRepository enderecoRepository;

    public UsuarioBean(UsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    public UsuarioBean(UsuarioRepository repository, PessoaRepository pessoaRepository) {
        this.usuarioRepository = repository;
        this.pessoaRepository = pessoaRepository;
    }

    public UsuarioBean(UsuarioRepository repository, PessoaRepository pessoaRepository, TelefoneRepository telefoneRepository) {
        this.usuarioRepository = repository;
        this.pessoaRepository = pessoaRepository;
        this.telefoneRepository = telefoneRepository;
    }

    public UsuarioBean(UsuarioRepository repository, PessoaRepository pessoaRepository, TelefoneRepository telefoneRepository,
                       EnderecoRepository enderecoRepository) {
        this.usuarioRepository = repository;
        this.pessoaRepository = pessoaRepository;
        this.telefoneRepository = telefoneRepository;
        this.enderecoRepository = enderecoRepository;
    }

    public void cadastrar(String dsEmail, String dsSenha, String nmPessoa, String tipoPessoa, List<Telefone> telefones,
                          String nmLogradouro, String tipoLogradouro, Integer nrLogradouro, String nmComplemento,
                          String nrCep, String nmBairro, String nmMunicipio, String nmEstado) {

        // Telefones
        for (Telefone telefone : telefones) {
            this.telefoneRepository.cadastrar(telefone);
            telefone.setId(this.telefoneRepository.getId());
        }

        Endereco endereco = new Endereco();
        endereco.setNmEstado(EnumTipoEstado.valueOf(nmEstado.toUpperCase()));
        endereco.setTipoLogradouro(EnumTipoLogradouro.valueOf(tipoLogradouro.toUpperCase()));
        endereco.setNmLogradouro(nmLogradouro);
        endereco.setNrLogradouro(nrLogradouro);
        endereco.setNmComplemento(nmComplemento);
        endereco.setNrCep(nrCep);
        endereco.setNmMunicipio(nmMunicipio);
        endereco.setNmBairro(nmBairro);
        this.enderecoRepository.cadastrar(endereco);
        endereco.setId(this.enderecoRepository.getId());

        // Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa(nmPessoa);
        pessoa.setTipoPessoa(EnumTipoPessoa.valueOf(tipoPessoa.toUpperCase()));
        pessoa.setTelefones(telefones);
        pessoa.setResidencial(endereco);
        this.pessoaRepository.cadastrar(pessoa);
        pessoa.setId(this.pessoaRepository.getId());

        // Usuario
        Usuario usuario = new Usuario();
        usuario.setDsEmail(dsEmail);
        usuario.setDsSenha(dsSenha);
        usuario.setPessoa(pessoa);
        usuarioRepository.cadastrar(usuario);
    }

    public Optional<Usuario> buscarPorId(long id) {
        return usuarioRepository.buscarPorId(obj -> obj.getId() == id);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.buscarTodos();
    }

    public void editar(long id, String dsEmail, String dsSenha, String nmPessoa, String tipoPessoa) { //, List<Telefone> telefones) {
        Optional<Usuario> usuario = usuarioRepository.buscarPorId(obj -> obj.getId() == id);
        if (usuario.isPresent()) {
            usuario.get().setDsEmail(dsEmail);
            usuario.get().setDsSenha(dsSenha);
            Pessoa pessoa = pessoaRepository.buscarPorId(pes -> pes.getId() == usuario.get().getPessoa().getId()).get();
            pessoa.setNmPessoa(nmPessoa);
            pessoa.setTipoPessoa(EnumTipoPessoa.valueOf(tipoPessoa.toUpperCase()));
//            for (Telefone telefone : telefones) {
//                telefoneRepository.atualizar(tel -> tel.getId() == telefone.getId(), telefone);
//            }
//            pessoa.setTelefones(telefones);
            pessoaRepository.atualizar(pes -> pes.getId() == pessoa.getId(), pessoa);
            usuarioRepository.atualizar(obj -> obj.getId() == id, usuario.get());
        }
    }

    public void remover(long id) {
        Optional<Usuario> usuario = usuarioRepository.buscarPorId(obj -> obj.getId() == id);
        if (usuario.isPresent()) {
            for (Telefone telefone :
                    usuario.get().getPessoa().getTelefones()) {
                telefoneRepository.remover(tel -> tel.getId() == telefone.getId());
            }
            pessoaRepository.remover(pes -> pes.getId() == usuario.get().getPessoa().getId());
            usuarioRepository.remover(usu -> usu.getId() == id);
        } else {
            System.out.println("Usuário não encontrado");
        }
    }

    public Optional<Usuario> buscarPorEmail(String dsEmail, String txSenha) {
        Optional<Usuario> usuario = usuarioRepository.buscarPorId(obj -> obj.getDsEmail() == dsEmail);
        if (usuario.isPresent()) {
            if (txSenha.equals(usuario.get().getDsSenha())) {
                return usuario;
            }
        }
        return Optional.empty();
    }
}
