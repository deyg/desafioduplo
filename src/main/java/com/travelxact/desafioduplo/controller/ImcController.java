package com.travelxact.desafioduplo.controller;

import com.travelxact.desafioduplo.entidades.Imc;
import com.travelxact.desafioduplo.service.ImcService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.DecimalFormat;

@RestController
public class ImcController {

    private final ImcService imcService;

    @Autowired
    public ImcController(ImcService imcService) {
        this.imcService = imcService;
    }

    @PostMapping("/imc")
    public ResponseEntity<String> calcularImc(@Valid @RequestBody Imc imcRequest) {

        double imc = imcService.calcularImc(imcRequest.getPeso(), imcRequest.getAltura());
        DecimalFormat df = new DecimalFormat("#,###.00");
        return ResponseEntity.ok("Seu IMC é: " + df.format(imc));
    }
}