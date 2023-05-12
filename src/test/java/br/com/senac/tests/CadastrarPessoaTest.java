package br.com.senac.tests;

import br.com.senac.tests.mockitoClass.ApiDosCorreios;
import br.com.senac.tests.mockitoClass.CadastrarPessoa;
import br.com.senac.tests.mockitoClass.DadosLocalizacao;
import br.com.senac.tests.mockitoClass.Pessoa;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {

    @Mock
    private ApiDosCorreios apiDosCorreios;
    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void cadastrarPessoa() {
        //1.2 Inserção dos dados a serem mockados
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RJ", "Duque de Caxias", "Rua Antonio alberto", "casa 7", "Rio de Janeiro");

        //1.3 Execução do Mock
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);

        //2. Execução e análise do teste
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("nome" ,"123456", LocalDate.of(2001, 03, 13), "25030150");
        DadosLocalizacao dadosLocalizacao1 = pessoa.getEndereco();
        assertEquals(dadosLocalizacao.getBairro(), dadosLocalizacao1.getBairro());
        assertEquals(dadosLocalizacao.getCidade(), dadosLocalizacao1.getCidade());
        assertEquals(dadosLocalizacao.getUf(), dadosLocalizacao1.getUf());
    }///
}
