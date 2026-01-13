package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Serviciu {

    @Id
    @Column(name = "id_serviciu")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serviciu_seq")
    @SequenceGenerator(name = "serviciu_seq", sequenceName = "SERVICIU_SEQ", allocationSize = 1)
    private Long idServiciu;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @Column(name = "denumire")
    private String denumire;

    @Column
    private BigDecimal pret;
}
