package com.travelxact.desafioduplo.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Gerente {

    private Nome nome;

    public Gerente(String nome){
        this.nome = new Nome(nome);
    }


}
