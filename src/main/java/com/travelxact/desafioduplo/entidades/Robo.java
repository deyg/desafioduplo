package com.travelxact.desafioduplo.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Robo {

    private Nome nome;

    public Robo(String nome){
        this.nome = new Nome(nome);
    }


}
