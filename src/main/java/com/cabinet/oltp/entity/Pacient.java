package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
public class Pacient {

    @Id
    @Column(name = "id_pacient")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pacient_seq")
    @SequenceGenerator(name = "pacient_seq", sequenceName = "PACIENT_SEQ", allocationSize = 1)
    private Long idPacient;

    @Column
    private String nume;

    @Column
    private String prenume;

    @Column(name = "numar_telefon")
    private String numarTelefon;
}
