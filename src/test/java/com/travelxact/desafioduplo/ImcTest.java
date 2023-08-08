package com.travelxact.desafioduplo;


import com.travelxact.desafioduplo.service.ImcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class ImcTest {

    @Autowired
    private ImcService imcService;

    @Test
    public void dado_peso_e_altura_deveria_retornar_Imc() {

        double peso = 70.0;
        double altura = 1.75;
        double imc = imcService.calcularImc(peso, altura);
        assertEquals(22.86, imc, 0.01);
    }
}