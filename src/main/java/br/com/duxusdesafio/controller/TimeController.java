package br.com.duxusdesafio.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.duxusdesafio.dto.ContagemFranquiaDto;
import br.com.duxusdesafio.dto.FranquiaMaisFamosaDto;
import br.com.duxusdesafio.dto.ListagemDosIntegrantesTimeMaisComumDto;
import br.com.duxusdesafio.dto.ListagemIntegrantesDto;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.service.ApiService;

@RestController
@RequestMapping("/duxusDesafio/time")
public class TimeController {

	@Autowired
	private ApiService apiService;
	@Autowired
	private TimeRepository timeRepository;

	@GetMapping("/timeData/{data}")
	public ResponseEntity<ListagemIntegrantesDto> consultaTimeDaData(@PathVariable String data) {

		LocalDate dataConvertida = apiService.conversaoData(data);

		List<String> listaDeIntegrantes = apiService.timeDaData(dataConvertida, timeRepository.findAll());

		ListagemIntegrantesDto listagem = new ListagemIntegrantesDto(listaDeIntegrantes);
		return ResponseEntity.ok(listagem);

	}

	@GetMapping("/timeMaisComum")
	public ResponseEntity<ListagemDosIntegrantesTimeMaisComumDto> consultaTimeComum(@RequestParam String dataInicial,
			@RequestParam String dataFinal) {
		LocalDate dataConvertidaInicial = apiService.conversaoData(dataInicial);

		LocalDate dataConvertidaFinal = apiService.conversaoData(dataFinal);

		List<String> timeMaisComum = apiService.timeMaisComum(dataConvertidaInicial, dataConvertidaFinal,
				timeRepository.findAll());

		ListagemDosIntegrantesTimeMaisComumDto listagemMaisComum = new ListagemDosIntegrantesTimeMaisComumDto(
				timeMaisComum);

		return ResponseEntity.ok(listagemMaisComum);
	}

	@GetMapping("/franquiaMaisComum")
	public ResponseEntity<FranquiaMaisFamosaDto> consultaFranquiaComum(@RequestParam String dataInicial,
			@RequestParam String dataFinal) {
		LocalDate dataConvertidaInicial = apiService.conversaoData(dataInicial);

		LocalDate dataConvertidaFinal = apiService.conversaoData(dataFinal);

		String franquiaMaisComum = apiService.franquiaMaisFamosa(dataConvertidaInicial, dataConvertidaFinal,
				timeRepository.findAll());

		FranquiaMaisFamosaDto franquiaMaisFamosaDto = new FranquiaMaisFamosaDto(franquiaMaisComum);

		return ResponseEntity.ok(franquiaMaisFamosaDto);
	}
	
	@GetMapping("/contagemFranquia")
	public ResponseEntity<ContagemFranquiaDto> consultaContagemFranquia(@RequestParam String dataInicial,
			@RequestParam String dataFinal) {
		LocalDate dataConvertidaInicial = apiService.conversaoData(dataInicial);

		LocalDate dataConvertidaFinal = apiService.conversaoData(dataFinal);

		Map<String, Long> contagemFranquia = apiService.contagemPorFranquia(dataConvertidaInicial, dataConvertidaFinal, timeRepository.findAll());

		ContagemFranquiaDto contagemFranquiaDto = new ContagemFranquiaDto(contagemFranquia);

		return ResponseEntity.ok(contagemFranquiaDto);
	}

}
