package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categorie {

    @Id
    @Column(name = "id_categorie")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorie_seq")
    @SequenceGenerator(name = "categorie_seq", sequenceName = "CATEGORIE_SEQ", allocationSize = 1)
    private Long idCategorie;

    @Column
    private String denumire;

}
