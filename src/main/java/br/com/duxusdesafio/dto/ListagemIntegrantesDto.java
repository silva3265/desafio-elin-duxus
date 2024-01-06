package br.com.duxusdesafio.dto;

import java.util.List;

public class ListagemIntegrantesDto {

	private List<String> integrantes;

	public ListagemIntegrantesDto(List<String> integrantes) {
		this.integrantes = integrantes;

	}

	public List<String> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<String> integrantes) {
		this.integrantes = integrantes;
	}

}
