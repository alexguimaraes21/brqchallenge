package br.com.fiap.brqchallenge.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Documento extends AbstractModel {

    private String dsDocumento;
    private String nrDocumento;
    private LocalDate dtDataExpedicao;
    private String orgaoExpedidor;
	private List<Arquivo> arquivos;

	public String getDsDocumento() {
		return dsDocumento;
	}

	public void setDsDocumento(String dsDocumento) {
		this.dsDocumento = dsDocumento;
	}

	public String getNrDocumento() {
		return nrDocumento;
	}

	public void setNrDocumento(String nrDocumento) {
		this.nrDocumento = nrDocumento;
	}

	public LocalDate getDtDataExpedicao() {
		return dtDataExpedicao;
	}

	public void setDtDataExpedicao(LocalDate dtDataExpedicao) {
		this.dtDataExpedicao = dtDataExpedicao;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public List<Arquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
}
