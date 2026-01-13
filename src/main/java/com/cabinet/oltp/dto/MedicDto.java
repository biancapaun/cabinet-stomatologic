package com.cabinet.oltp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MedicDto {

    private Long idMedic;

    @NotBlank(message = "Numele este obligatoriu")
    private String nume;

    @NotBlank(message = "Prenumele este obligatoriu")
    private String prenume;
}
