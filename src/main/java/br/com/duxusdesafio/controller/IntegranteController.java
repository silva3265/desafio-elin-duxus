package br.com.duxusdesafio.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.dto.FuncaoMaisComumDto;
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

		LocalDate dataConvertidaInicial = apiService.conversaoData(dataInicial);

		LocalDate dataConvertidaFinal = apiService.conversaoData(dataFinal);

		Integrante integranteMaisUsado = apiService.integranteMaisUsado(dataConvertidaInicial, dataConvertidaFinal,
				timeRepository.findAll());

		IntegranteMaisUsadoDto integrantemaisUsadoDto = new IntegranteMaisUsadoDto(integranteMaisUsado);
		return ResponseEntity.ok(integrantemaisUsadoDto);

	}

	@GetMapping("/funcaoMaisComum")
	public ResponseEntity<FuncaoMaisComumDto> funcaoMaisComum(@RequestParam String dataInicial,
			@RequestParam String dataFinal) {

		LocalDate dataConvertidaInicial = apiService.conversaoData(dataInicial);

		LocalDate dataConvertidaFinal = apiService.conversaoData(dataFinal);

		String funcaoMaisComum = apiService.funcaoMaisComum(dataConvertidaInicial, dataConvertidaFinal,
				timeRepository.findAll());

		FuncaoMaisComumDto funcaoMaisComumDto = new FuncaoMaisComumDto(funcaoMaisComum);
		return ResponseEntity.ok(funcaoMaisComumDto);

	}
}
