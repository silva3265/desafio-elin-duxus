package br.com.duxusdesafio.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		
		// Precisamos Converter a Data do Tipo 'String' para o Tipo 'LocalDate'
		String[] dataSplit = data.split("-");

		Integer dia = Integer.parseInt(dataSplit[0]);
		Integer mes = Integer.parseInt(dataSplit[1]);
		Integer ano = Integer.parseInt(dataSplit[2]);

		LocalDate dataConvertida = LocalDate.of(ano, mes, dia);

		List<String> listaDeIntegrantes = apiService.timeDaData(dataConvertida, timeRepository.findAll());

		ListagemIntegrantesDto listagem = new ListagemIntegrantesDto(listaDeIntegrantes);
		return ResponseEntity.ok(listagem);

	}

}
