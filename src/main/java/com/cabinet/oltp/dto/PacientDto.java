package com.cabinet.oltp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PacientDto {

    private Long idPacient;

    @NotBlank(message = "Numele este obligatoriu!")
    private String nume;

    @NotBlank(message = "Prenumele este obligatoriu!")
    private String prenume;

    @NotBlank(message = "Numarul de telefon este obligatoriu!")
    private String numarTelefon;
}
