package br.com.duxusdesafio.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.duxusdesafio.dto.CadastroIntegrantesDto;
import br.com.duxusdesafio.dto.ContagemPorFuncaoDto;
import br.com.duxusdesafio.dto.FuncaoMaisComumDto;
import br.com.duxusdesafio.dto.IntegranteMaisUsadoDto;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.repository.IntegranteRepository;
import br.com.duxusdesafio.repository.TimeRepository;
import br.com.duxusdesafio.service.ApiService;

@Controller
@RequestMapping("/duxusDesafio/integrante")
public class IntegranteController {

	@Autowired
	private ApiService apiService;
	
	@Autowired
	private TimeRepository timeRepository;
	
	@Autowired
	private IntegranteRepository integranteRepository;

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

	@GetMapping("/contagemPorFuncao")
	public ResponseEntity<ContagemPorFuncaoDto> contagemPorFuncao(@RequestParam String dataInicial,
			@RequestParam String dataFinal) {

		LocalDate dataConvertidaInicial = apiService.conversaoData(dataInicial);

		LocalDate dataConvertidaFinal = apiService.conversaoData(dataFinal);

		Map<String, Long> contagemPorFuncao = apiService.contagemPorFuncao(dataConvertidaInicial, dataConvertidaFinal,
				timeRepository.findAll());

		ContagemPorFuncaoDto contagemPorFuncaoDto = new ContagemPorFuncaoDto(contagemPorFuncao);

		return ResponseEntity.ok(contagemPorFuncaoDto);

	}

	@PostMapping("/cadastro")
	public String cadastroIntegrante(@ModelAttribute CadastroIntegrantesDto cadastro) {

		Integrante integrante = new Integrante(cadastro.getNome(), cadastro.getFuncao(), cadastro.getFranquia());

		integranteRepository.save(integrante);
		
		return "redirect:/duxusDesafio/integrante/visualizar";
	}
	
	@GetMapping("/cadastro")
	public String cadastroIntegrante(Model model) {

		model.addAttribute("integrante", new CadastroIntegrantesDto());
		
		return "cadastroIntegrante";
	}
	
	@GetMapping("/visualizar")
	public String visualizarIntegrante(Model model) {

		model.addAttribute("integrantes", integranteRepository.findAll());
		
		return "visualizarIntegrantes";
	}
}