package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Departament {

    @Id
    @Column(name = "id_departament")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departament_seq")
    @SequenceGenerator(name = "departament_seq", sequenceName = "DEPARTAMENT_SEQ", allocationSize = 1)
    private Long idDepartament;

    @Column
    private String denumire;

    @OneToMany(mappedBy = "departament", fetch = FetchType.EAGER)
    private List<Angajat> angajati;
}
