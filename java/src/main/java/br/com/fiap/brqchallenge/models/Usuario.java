package br.com.fiap.brqchallenge.models;

import java.time.LocalDateTime;
import java.util.Optional;

public class Usuario {

	private long id;

	private String dsEmail;

	private String dsSenha;

	private LocalDateTime dtHrUltimaAtualizacao;

	private LocalDateTime dtHrUltimoLogin;

	private LocalDateTime dtHrCadastro;

	private boolean ckAtivado;

	private Pessoa pessoa;

	public Usuario() {
		this.ckAtivado = true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public LocalDateTime getDtHrUltimaAtualizacao() {
		return dtHrUltimaAtualizacao;
	}

	public void setDtHrUltimaAtualizacao(LocalDateTime dtHrUltimaAtualizacao) {
		this.dtHrUltimaAtualizacao = dtHrUltimaAtualizacao;
	}

	public LocalDateTime getDtHrUltimoLogin() {
		return dtHrUltimoLogin;
	}

	public void setDtHrUltimoLogin(LocalDateTime dtHrUltimoLogin) {
		this.dtHrUltimoLogin = dtHrUltimoLogin;
	}

	public LocalDateTime getDtHrCadastro() {
		return dtHrCadastro;
	}

	public void setDtHrCadastro(LocalDateTime dtHrCadastro) {
		this.dtHrCadastro = dtHrCadastro;
	}

	public boolean isCkAtivado() {
		return ckAtivado;
	}

	public void setCkAtivado(boolean ckAtivado) {
		this.ckAtivado = ckAtivado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void cadastrar(Usuario usuario) {

	}

	public void editar(long id, Usuario usuario) {

	}

	public void ativarDesativar(long id) {

	}

	public void trocarSenha(long id, String dsSenha) {

	}

	public Optional<Usuario> detalhes(long id) {
		return null;
	}

}
