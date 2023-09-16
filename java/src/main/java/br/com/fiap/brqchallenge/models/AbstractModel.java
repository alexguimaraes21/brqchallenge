package br.com.fiap.brqchallenge.models;

import java.time.LocalDateTime;

public abstract class AbstractModel {

	protected long id;

	protected LocalDateTime cadastradoEm;

	protected Usuario cadastradoPor;

	protected LocalDateTime atualizadoEm;

	protected Usuario atualizadoPor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getCadastradoEm() {
		return cadastradoEm;
	}

	public void setCadastradoEm(LocalDateTime cadastradoEm) {
		this.cadastradoEm = cadastradoEm;
	}

	public Usuario getCadastradoPor() {
		return cadastradoPor;
	}

	public void setCadastradoPor(Usuario cadastradoPor) {
		this.cadastradoPor = cadastradoPor;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	public Usuario getAtualizadoPor() {
		return atualizadoPor;
	}

	public void setAtualizadoPor(Usuario atualizadoPor) {
		this.atualizadoPor = atualizadoPor;
	}
}
