package com.cabinet.oltp.service;

import com.cabinet.oltp.dto.PacientDto;
import com.cabinet.oltp.entity.Pacient;
import com.cabinet.oltp.exceptions.ResourceNotFoundException;
import com.cabinet.oltp.repository.PacientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacientService {

    private final PacientRepository pacientRepository;
    private final ModelMapper modelMapper;

    public PacientService(PacientRepository pacientRepository, ModelMapper modelMapper) {
        this.pacientRepository = pacientRepository;
        this.modelMapper = modelMapper;
    }

    public List<Pacient> findAll() {
        return pacientRepository.findAll();
    }

    public void savePacient(PacientDto pacientDto) {
        Pacient pacientEntity = modelMapper.map(pacientDto, Pacient.class);
        pacientRepository.save(pacientEntity);
    }

    public void deletePacientById(Long id) {
        pacientRepository.deleteById(id);
    }

    public PacientDto findPacientById(Long id) {
        Optional<Pacient> pacientOptional = pacientRepository.findById(id);
        if (!pacientOptional.isPresent()) {
            throw new ResourceNotFoundException("Pacientul cu id " + id + " nu a fost gasit!");
        }

        return modelMapper.map(pacientOptional.get(), PacientDto.class);
    }

    public void updatePacient(Long id, PacientDto pacientDto) {
        Optional<Pacient> pacientEntity = pacientRepository.findById(id);
        if (!pacientEntity.isPresent()) {
            throw new ResourceNotFoundException("Pacientul cu id" + id + " nu a fost gasit!");
        }
        modelMapper.map(pacientDto, pacientEntity.get());
        pacientRepository.save(pacientEntity.get());
    }
}
