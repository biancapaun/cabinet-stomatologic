package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Incasare {

    @Id
    @Column(name = "id_incasare")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incasare_seq")
    @SequenceGenerator(name = "incasare_seq", sequenceName = "INCASARE_SEQ", allocationSize = 1)
    private Long idIncasare;

    @ManyToOne
    @JoinColumn(name = "id_programare")
    private Programare programare;

    @ManyToOne
    @JoinColumn(name = "id_factura_emisa")
    private FacturaEmisa facturaEmisa;

    @ManyToOne
    @JoinColumn(name = "id_tip_plata")
    private TipPlata tipPlata;

    @Column
    private LocalDate data;

    @Column
    private BigDecimal suma;
}
