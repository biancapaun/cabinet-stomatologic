package com.cabinet.oltp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Medic {

    @Id
    @Column(name = "id_angajat")
    private Long idAngajat;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_angajat")
    private Angajat angajat;

    @Column
    private String specializare;

    @Column
    private String parafa;
}
