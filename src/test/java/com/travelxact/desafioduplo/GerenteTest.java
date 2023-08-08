package com.travelxact.desafioduplo;

import com.travelxact.desafioduplo.entidades.Gerente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class GerenteTest {

	@Test
	void dado_nomeVazioParaGerente_deveria_lancar_excecao() {
		assertThrows(IllegalArgumentException.class, () -> new Gerente(""));
	}

	@Test
	void dado_nomeNuloParaGerente_deveria_lancar_excecao() {
		assertThrows(IllegalArgumentException.class, () -> new Gerente(null));
	}

	@Test
	void dado_nomeUnicoParaGerente_deveria_retornar_mesmoNome() {
		String nomeUnico = "João Soares Silva";
		Gerente gerente = new Gerente(nomeUnico);

		assertEquals(nomeUnico, gerente.getNome().getNomeCompleto());
	}
}
