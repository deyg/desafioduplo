package com.travelxact.desafioduplo;

import com.travelxact.desafioduplo.entidades.Nome;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class NomeTest {

	@Test
	void dado_nomeCompleto_deveria_retornar_primeiroNome() {
		Nome nome = new Nome("João Soares Silva");
		assertEquals("João", nome.getPrimeiroNome());
	}

	@Test
	void dado_nomeCompleto_deveria_retornar_ultimoNome() {
		Nome nome = new Nome("João Soares Silva");
		assertEquals("Soares Silva", nome.getUltimoNome());
	}

	@Test
	void dado_nomeCompleto_deveria_retornar_nomeMaiusculo() {
		Nome nome = new Nome("João Soares Silva");
		assertEquals("JOÃO SOARES SILVA", nome.getNomeMaiusculo());
	}

	@Test
	void dado_nomeCompleto_deveria_retornar_nomeAbreviado() {
		Nome nome = new Nome("João Soares Silva");
		assertEquals("João S. Silva", nome.getNomeAbreviado());
	}

	@Test
	void dado_nomeNulo_deveria_lancar_excecao() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Nome(null));
		assertEquals("O nome não pode ser nulo.", exception.getMessage());
	}

	@Test
	void dado_nomeVazio_deveria_lancar_excecao() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Nome(""));
		assertEquals("O nome não pode ser vazio.", exception.getMessage());
	}

	@Test
	void dado_nomeCompletoComMenosDeDuasPalavras_deveria_lancar_excecao() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Nome("João"));
		assertEquals("O nome completo deve conter pelo menos duas palavras.", exception.getMessage());
	}

	@Test
	void dado_nomeCompletoComEspacosExtras_deveria_tratarNomeCompleto() {
		Nome nome = new Nome("   João    Soares Silva   ");
		assertEquals("JOÃO SOARES SILVA", nome.getNomeMaiusculo());
	}

	@Test
	void dado_nomeCompletoComEspacosExtras_deveria_retornar_nomeCompleto() {
		Nome nome = new Nome("   João    Soares Silva   ");
		assertEquals("João Soares Silva", nome.getNomeCompleto());
	}
}
