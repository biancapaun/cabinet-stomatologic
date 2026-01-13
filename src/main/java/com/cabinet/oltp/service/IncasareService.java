package com.cabinet.oltp.service;

import com.cabinet.oltp.entity.Incasare;
import com.cabinet.oltp.repository.IncasareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncasareService {

    private final IncasareRepository incasareRepository;

    public IncasareService(IncasareRepository incasareRepository) {
        this.incasareRepository = incasareRepository;
    }

    public List<Incasare> findAll() {
        return incasareRepository.findAll();
    }
}
