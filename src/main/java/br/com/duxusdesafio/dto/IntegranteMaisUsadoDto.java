package br.com.duxusdesafio.dto;

import br.com.duxusdesafio.model.Integrante;

public class IntegranteMaisUsadoDto {
	
	
	public IntegranteMaisUsadoDto(Integrante integrante) {
		this.integrante = integrante;
	}

	private Integrante integrante;

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}
	
	

}
