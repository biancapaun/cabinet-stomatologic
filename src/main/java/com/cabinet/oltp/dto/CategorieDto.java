package com.cabinet.oltp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategorieDto {

    private Long idCategorie;

    @NotBlank(message = "Denumirea este obligatorie!")
    private String denumire;
}
