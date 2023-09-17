package br.com.fiap.brqchallenge.beans;

import br.com.fiap.brqchallenge.enums.EnumTipoPessoa;
import br.com.fiap.brqchallenge.models.Acessorio;
import br.com.fiap.brqchallenge.models.Pessoa;
import br.com.fiap.brqchallenge.models.Telefone;
import br.com.fiap.brqchallenge.models.Usuario;
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

    public void cadastrar(String dsEmail, String dsSenha, String nmPessoa, String tipoPessoa, List<Telefone> telefones) {

        // Telefones
        for (Telefone telefone : telefones) {
            this.telefoneRepository.cadastrar(telefone);
            telefone.setId(this.telefoneRepository.getId());
        }

        // Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa(nmPessoa);
        pessoa.setTipoPessoa(EnumTipoPessoa.valueOf(tipoPessoa.toUpperCase()));
        pessoa.setTelefones(telefones);
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

    public void editar(long id, String dsEmail, String dsSenha, String nmPessoa, String tipoPessoa, List<Telefone> telefones) {
        Optional<Usuario> usuario = usuarioRepository.buscarPorId(obj -> obj.getId() == id);
        if (usuario.isPresent()) {
            usuario.get().setDsEmail(dsEmail);
            usuario.get().setDsSenha(dsSenha);
            Pessoa pessoa = pessoaRepository.buscarPorId(pes -> pes.getId() == usuario.get().getPessoa().getId()).get();
            pessoa.setNmPessoa(nmPessoa);
            pessoa.setTipoPessoa(EnumTipoPessoa.valueOf(tipoPessoa.toUpperCase()));
            for (Telefone telefone : telefones) {
                telefoneRepository.atualizar(tel -> tel.getId() == telefone.getId(), telefone);
            }
            pessoa.setTelefones(telefones);
            pessoaRepository.atualizar(pes -> pes.getId() == pessoa.getId(), pessoa);
            usuarioRepository.atualizar(obj -> obj.getId() == id, usuario.get());
        }
    }
}
