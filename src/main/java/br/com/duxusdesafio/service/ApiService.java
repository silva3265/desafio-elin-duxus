package br.com.duxusdesafio.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.duxusdesafio.model.ComposicaoTime;
import br.com.duxusdesafio.model.Integrante;
import br.com.duxusdesafio.model.Time;

/**
 * Service que possuirá as regras de negócio para o processamento dos dados
 * solicitados no desafio!
 *
 * @author carlosau
 */
@Service
public class ApiService {

	/**
	 * Vai retornar uma lista com os nomes dos integrantes do time daquela data
	 */
	public List<String> timeDaData(LocalDate data, List<Time> todosOsTimes) {
		List<String> listaNomesIntegrantes = new ArrayList<>();

		for (Time time : todosOsTimes) {
			if (data.equals(time.getData())) {
				List<ComposicaoTime> listaComposicaoes = time.getComposicaoTime();
				for (ComposicaoTime composicao : listaComposicaoes) {
					listaNomesIntegrantes.add(composicao.getIntegrante().getNome());
				}
			}
		}
		return listaNomesIntegrantes;
	}

	/**
     * Vai retornar o integrante que tiver presente na maior quantidade de times
     * dentro do período
     */
    public Integrante integranteMaisUsado(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes){
    	LocalDate dataTime = null;
    	Map<Integrante, Integer> listaContagem = new HashMap<>();
    	
    	for (Time timePresente : todosOsTimes) {
    		dataTime = timePresente.getData();
			if (dataTime.isAfter(dataInicial.minusDays(1))&& dataTime.isBefore(dataFinal.plusDays(1))) {
				List<ComposicaoTime> composicoesTime = timePresente.getComposicaoTime(); 
				for (ComposicaoTime timeComposicao : composicoesTime) { 
					Integrante integrante = timeComposicao.getIntegrante(); 
					listaContagem.put(integrante, listaContagem.getOrDefault(integrante, 0) + 1 ); // se existe um valor, o integrante apareceu pelo menos uma vez se aparecer ele vai somar com + 1
					
				}
			}
    	}
    	int maiorContagem = 0;
    	Integrante integranteMaisUsado = null;
    	for (Map.Entry<Integrante, Integer> entryMap : listaContagem.entrySet()) { /* pra percorrer uma lista do tipo 'Map', pra cada iteração ele vai gerar uma (K, V)*/
			
    		if (entryMap.getValue() > maiorContagem) { /* Condição para verificar se o Integrante aparece mais de uma vez*/
    			maiorContagem = entryMap.getValue();
    			integranteMaisUsado = entryMap.getKey();
			}
		}
    	
    	
        return integranteMaisUsado;
    }

	/**
	 * Vai retornar uma lista com os nomes dos integrantes do time mais comum dentro
	 * do período
	 */
	public List<String> timeMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
		// TODO Implementar método seguindo as instruções!
		return null;
	}

	/**
	 * Vai retornar a função mais comum nos times dentro do período
	 */
	public String funcaoMaisComum(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
		// TODO Implementar método seguindo as instruções!
		return null;
	}

	/**
	 * Vai retornar o nome da Franquia mais comum nos times dentro do período
	 */
	public String franquiaMaisFamosa(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
		// TODO Implementar método seguindo as instruções!
		return null;
	}

	/**
	 * Vai retornar o nome da Franquia mais comum nos times dentro do período
	 */
	public Map<String, Long> contagemPorFranquia(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
		// TODO Implementar método seguindo as instruções!
		return null;
	}

	/**
	 * Vai retornar o número (quantidade) de Funções dentro do período
	 */
	public Map<String, Long> contagemPorFuncao(LocalDate dataInicial, LocalDate dataFinal, List<Time> todosOsTimes) {
		// TODO Implementar método seguindo as instruções!
		return null;
	}

}
