package com.travelxact.desafioduplo;

import com.travelxact.desafioduplo.controller.ImcController;
import com.travelxact.desafioduplo.entidades.Imc;
import com.travelxact.desafioduplo.service.ImcService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@WebMvcTest(ImcController.class)
class ImcControllerTest {

    @Autowired
    private ImcController imcController;

    @MockBean
    private ImcService imcService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void deveria_retornar_o_imc_quando_informar_altura_e_peso() {

        Imc imcRequest = new Imc();
        imcRequest.setPeso(70.0);
        imcRequest.setAltura(1.75);

        Mockito.when(imcService.calcularImc(imcRequest.getPeso(), imcRequest.getAltura())).thenReturn(22.86);

        ResponseEntity<String> responseEntity = imcController.calcularImc(imcRequest);

        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("Seu IMC é: 22,86", responseEntity.getBody());

        verify(imcService, times(1)).calcularImc(imcRequest.getPeso(), imcRequest.getAltura());
    }


}
