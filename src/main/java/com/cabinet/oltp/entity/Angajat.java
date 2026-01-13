package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Angajat {

    @Id
    @Column(name = "id_angajat")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "angajat_seq")
    @SequenceGenerator(name = "angajat_seq", sequenceName = "ANGAJAT_SEQ", allocationSize = 1)
    private Long idAngajat;

    @Column
    private String cnp;

    @Column
    private String nume;

    @Column
    private String prenume;

    @Column(name = "data_nastere")
    private LocalDate dataNastere;

    @Column
    private String domiciliu;

    @Column(name = "numar_telefon")
    private String numarTelefon;

    @Column(name = "salariu_brut")
    private BigDecimal salariuBrut;

    @ManyToOne
    @JoinColumn(name = "id_departament")
    private Departament departament;
}
