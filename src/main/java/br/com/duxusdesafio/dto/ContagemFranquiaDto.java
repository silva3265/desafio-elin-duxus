package br.com.duxusdesafio.dto;

import java.util.Map;

public class ContagemFranquiaDto {
	
	public ContagemFranquiaDto(Map<String, Long> contagemFranquia) {
		this.contagemFranquia = contagemFranquia;
	}

	private Map<String, Long> contagemFranquia;

	public Map<String, Long> getContagemFranquia() {
		return contagemFranquia;
	}

	public void setContagemFranquia(Map<String, Long> contagemFranquia) {
		this.contagemFranquia = contagemFranquia;
	}
	
	

}
