package br.com.duxusdesafio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.dto.IntegranteMaisUsadoDto;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.service.ApiService;

@RestController
@RequestMapping("/duxusDesafio/integrante")
public class IntegranteController {

	@Autowired
	private ApiService apiService;
	@Autowired
	private TimeRepository timeRepository;

	@GetMapping("/maisUsado")
	public ResponseEntity<IntegranteMaisUsadoDto> integranteMaisUsado(@RequestParam String dataInicial,
			@RequestParam String dataFinal) {

		String[] dataInicialSplit = dataInicial.split("-");
		String[] dataFinalSplit = dataFinal.split("-");

		String diaDataInicial = dataInicialSplit[0];
		String mesDataInicial = dataInicialSplit[1];
		String anoDataInicial = dataInicialSplit[2];

		String diaDataFinal = dataFinalSplit[0];
		String mesDataFinal = dataFinalSplit[1];
		String anoDataFinal = dataFinalSplit[2];

		Integer diaInicialConvertido = Integer.parseInt(diaDataInicial);
		Integer mesInicialConvertido = Integer.parseInt(mesDataInicial);
		Integer anoInicialConvertido = Integer.parseInt(anoDataInicial);

		Integer diaFinalConvertido = Integer.parseInt(diaDataFinal);
		Integer mesFinalConvertido = Integer.parseInt(mesDataFinal);
		Integer anoFinalConvertido = Integer.parseInt(anoDataFinal);

		LocalDate dataConvertidaInicial = LocalDate.of(anoInicialConvertido, mesInicialConvertido,
				diaInicialConvertido);

		LocalDate dataConvertidaFinal = LocalDate.of(anoFinalConvertido, mesFinalConvertido, diaFinalConvertido);

		Integrante integranteMaisUsado = apiService.integranteMaisUsado(dataConvertidaInicial, dataConvertidaFinal,
				timeRepository.findAll());

		IntegranteMaisUsadoDto integrantemaisUsadoDto = new IntegranteMaisUsadoDto(integranteMaisUsado);
		return ResponseEntity.ok(integrantemaisUsadoDto);

	}
}
