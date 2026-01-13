package com.cabinet.oltp.service;

import com.cabinet.oltp.entity.Medic;
import com.cabinet.oltp.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicService {

    private final MedicRepository medicRepository;

    public MedicService(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    public List<Medic> findAll() {
        return medicRepository.findAll();
    }
}
