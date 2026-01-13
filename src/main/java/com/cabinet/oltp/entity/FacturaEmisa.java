package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class FacturaEmisa {

    @Id
    @Column(name = "id_factura_emisa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "factura_seq")
    @SequenceGenerator(name = "factura_seq", sequenceName = "FACTURA_SEQ", allocationSize = 1)
    private Long idFacturaEmisa;

    @ManyToOne
    @JoinColumn(name = "id_programare")
    private Programare programare;

    @Column
    private String serie;

    @Column
    private Long numar;

    @Column(name = "data_emitere")
    private LocalDate dataEmitere;

    @Column(name = "data_scadenta")
    private LocalDate dataScadenta;

    @Column(name = "adresa_sediu")
    private String adresaSediu;

    @Column(name = "adresa_client")
    private String adresaClient;

    @Column
    private BigDecimal suma;

    @Column(name = "cont_iban")
    private String contIban;
}
