package br.com.fiap.brqchallenge.models;

import br.com.fiap.brqchallenge.enums.EnumTipoPessoa;

import java.util.List;

public class Pessoa {

	private long id;
	private String nmPessoa;
	private EnumTipoPessoa tipoPessoa;
	private List<Telefone> telefones;
	private Endereco residencial;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public EnumTipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Endereco getResidencial() {
		return residencial;
	}

	public void setResidencial(Endereco residencial) {
		this.residencial = residencial;
	}
}
