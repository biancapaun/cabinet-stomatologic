package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Programare {

    @Id
    @Column(name = "id_programare")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "programare_seq")
    @SequenceGenerator(name = "programare_seq", sequenceName = "PROGRAMARE_SEQ", allocationSize = 1)
    private Long idProgramare;

    @ManyToOne
    @JoinColumn(name = "id_pacient")
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "id_medic")
    private Medic medic;

    @ManyToOne
    @JoinColumn(name = "id_serviciu")
    private Serviciu serviciu;

    @Column(name = "data_ora")
    private LocalDateTime dataOra;

    @Column
    private String confirmare;
}
