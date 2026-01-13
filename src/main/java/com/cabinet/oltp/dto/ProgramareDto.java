package com.cabinet.oltp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProgramareDto {

    private Long idProgramare;

    @NotNull(message = "Selectați un pacient!")
    private Long idPacient;

    @NotNull(message = "Selectați un medic!")
    private Long idMedic;

    @NotNull(message = "Selectați un serviciu!")
    private Long idServiciu;

    @NotNull(message = "Selectați data și ora!")
    private LocalDateTime dataOra;
}
