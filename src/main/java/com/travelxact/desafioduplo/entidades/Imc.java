package com.travelxact.desafioduplo.entidades;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@NoArgsConstructor
public class Imc {

    @NotNull(message = "O peso nao pode ser null.")
    @Positive(message = "O peso deve ser maior que zero.")
    private Double peso;

    @NotNull(message = "A altura nao pode ser null.")
    @Positive(message = "A altura deve ser maior que zero.")
    private Double altura;


}