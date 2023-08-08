package com.travelxact.desafioduplo.entidades;

import lombok.EqualsAndHashCode;

import java.util.Arrays;

@EqualsAndHashCode
public class Nome {

    private final String nomeCompleto;

    public Nome(String nomeCompleto) {

        validarNome(nomeCompleto);
        String nomeTratado = tratarNomeCompleto(nomeCompleto);
        this.nomeCompleto = nomeTratado;

    }

    public String getNomeCompleto(){
        return  this.nomeCompleto;
    }

    public String getPrimeiroNome() {
        String[] nomes = nomeCompleto.split(" ");
        return nomes[0];
    }

    public String getUltimoNome() {
        String[] nomes = nomeCompleto.split(" ");
        return String.join(" ", Arrays.copyOfRange(nomes, 1, nomes.length));
    }

    public String getNomeMaiusculo() {
        return nomeCompleto.toUpperCase();
    }

    public String getNomeAbreviado() {

       String[] nomes = nomeCompleto.split(" ");
       StringBuilder abreviado = new StringBuilder(nomes[0]);

        for (int i = 1; i < nomes.length - 1; i++) {
            abreviado.append(" ").append(nomes[i].charAt(0)).append(".");
        }

        if (nomes.length > 1) {
            abreviado.append(" ").append(nomes[nomes.length - 1]);
        }

        return abreviado.toString();
    }

    private void validarNome(String nomeCompleto) {

        if (nomeCompleto == null) {
            throw new IllegalArgumentException("O nome não pode ser nulo.");
        }

        if (nomeCompleto.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        String[] nomes = nomeCompleto.split(" ");
        if (nomes.length < 2) {
            throw new IllegalArgumentException("O nome completo deve conter pelo menos duas palavras.");
        }

    }

    private String tratarNomeCompleto(String nomeCompleto) {

        String nomeTratado = nomeCompleto.trim();
        nomeTratado = nomeTratado.replaceAll("\\s{2,}", " ");
        return nomeTratado;
    }

}
