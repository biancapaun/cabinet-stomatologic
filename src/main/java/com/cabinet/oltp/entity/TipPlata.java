package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TipPlata {

    @Id
    @Column(name = "id_tip_plata")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tip_plata_seq")
    @SequenceGenerator(name = "tip_plata_seq", sequenceName = "TIP_PLATA_SEQ", allocationSize = 1)
    private Long idTipPlata;

    @Column
    private String denumire;
}
