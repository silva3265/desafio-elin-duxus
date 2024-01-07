package br.com.duxusdesafio.dto;

import java.util.List;

public class ListagemDosIntegrantesTimeMaisComumDto {

	public ListagemDosIntegrantesTimeMaisComumDto(List<String> timeMaisComum) {
		this.timeMaisComum = timeMaisComum;
	}

	private List<String> timeMaisComum;
	
	public List<String> getTimeMaisComum() {
		return timeMaisComum;
	}

	public void setTimeMaisComum(List<String> timeMaisComum) {
		this.timeMaisComum = timeMaisComum;
	}

	
}
