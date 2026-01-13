package com.cabinet.oltp.service;

import com.cabinet.oltp.entity.Angajat;
import com.cabinet.oltp.repository.AngajatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AngajatService {

    private final AngajatRepository angajatRepository;

    public AngajatService(AngajatRepository angajatRepository) {
        this.angajatRepository = angajatRepository;
    }

    public List<Angajat> findAll() {
        return angajatRepository.findAllEmployersWithDepartments();
    }
}
