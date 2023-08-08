package com.travelxact.desafioduplo;

import com.travelxact.desafioduplo.entidades.Robo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class RoboTest {

	@Test
	void dado_nomeVazioParaRobo_deveria_lancar_excecao() {
		assertThrows(IllegalArgumentException.class, () -> new Robo(""));
	}

	@Test
	void dado_nomeNuloParaRobo_deveria_lancar_excecao() {
		assertThrows(IllegalArgumentException.class, () -> new Robo(null));
	}

	@Test
	void dado_nomeUnicoParaRobo_deveria_retornar_mesmoNome() {
		String nomeUnico = "João Soares Silva";
		Robo robo = new Robo(nomeUnico);

		assertEquals(nomeUnico, robo.getNome().getNomeCompleto());
	}
}
