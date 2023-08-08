package com.travelxact.desafioduplo;

import com.travelxact.desafioduplo.entidades.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class ClienteTest {

	@Test
	void dado_nomeVazioParaCliente_deveria_lancar_excecao() {
		assertThrows(IllegalArgumentException.class, () -> new Cliente(""));
	}

	@Test
	void dado_nomeNuloParaCliente_deveria_lancar_excecao() {
		assertThrows(IllegalArgumentException.class, () -> new Cliente(null));
	}

	@Test
	void dado_nomeUnicoParaCliente_deveria_retornar_mesmoNome() {
		String nomeUnico = "João Soares Silva";
		Cliente cliente = new Cliente(nomeUnico);

		assertEquals(nomeUnico, cliente.getNome().getNomeCompleto());
	}
}
