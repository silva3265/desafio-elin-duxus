package br.com.duxusdesafio.controller;

import java.util.ArrayList;
import java.util.List;

public class Exercicio {

	public static void main(String[] args) {
		
		
		String dataInicial = "20-06-2023";
	
		
		String[]dataInicialSplit = dataInicial.split("-");
		
		System.out.println(dataInicialSplit[2]);
		
//		String dia = dataFinalSplit[0];
//		String mes = dataFinalSplit[1];
//		String ano = dataFinalSplit[2];
		
		List<String> data = new ArrayList<>();
		
		data.add("20");
		data.add("06");
		data.add("2023");
		
		System.out.println(data.get(0));
	}
}
