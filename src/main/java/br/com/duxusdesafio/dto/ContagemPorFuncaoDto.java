package br.com.duxusdesafio.dto;

import java.util.Map;

public class ContagemPorFuncaoDto {

	public ContagemPorFuncaoDto(Map<String, Long> contagemPorFuncao) {
		this.contagemPorFuncao = contagemPorFuncao;
	}

	private Map<String, Long> contagemPorFuncao;

	public Map<String, Long> getContagemPorFuncao() {
		return contagemPorFuncao;
	}

	public void setContagemPorFuncao(Map<String, Long> contagemPorFuncao) {
		this.contagemPorFuncao = contagemPorFuncao;
	}

}
