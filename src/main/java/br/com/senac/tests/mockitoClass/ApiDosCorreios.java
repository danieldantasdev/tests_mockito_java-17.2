package br.com.senac.tests.mockitoClass;

import java.time.LocalDate;

public class ApiDosCorreios {
	/**
	 * Classe de simulação de uma integração com a API dos correios
	 */
	private ApiDosCorreios apiDosCorreios;
	
	public ApiDosCorreios() {
		// TODO Auto-generated constructor stub
	}

	public DadosLocalizacao buscaDadosComBaseNoCep(String cep) {
		return null;
	};

	public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep) {
		Pessoa pessoa = new Pessoa(nome, documento, nascimento);
		DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComBaseNoCep(cep);
		pessoa.adicionaDadosEndereco(dadosLocalizacao);
		
		return pessoa;
	}
}
