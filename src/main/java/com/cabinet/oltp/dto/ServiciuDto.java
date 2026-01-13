package com.cabinet.oltp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServiciuDto {

    private Long idServiciu;

    @NotNull(message = "Selectați o categorie!")
    private Long idCategorie;

    @NotBlank(message = "Denumirea este obligatorie!")
    private String denumire;

    @NotNull(message = "Pretul este obligatoriu!")
    private BigDecimal pret;
}
