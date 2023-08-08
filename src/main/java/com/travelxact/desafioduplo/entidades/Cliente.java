package com.travelxact.desafioduplo.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Cliente {

    private Nome nome;

    public Cliente(String nome){
        this.nome = new Nome(nome);
    }


}
