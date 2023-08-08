package com.travelxact.desafioduplo.service;

import org.springframework.stereotype.Service;

@Service
public class ImcService {

    public double calcularImc(double peso, double altura) {

        if(peso > 0 && altura > 00){
            return peso / (altura * altura);
        }else{
            throw new RuntimeException("O peso e a altura devem ser maiores do que zero.");
        }

    }
}

