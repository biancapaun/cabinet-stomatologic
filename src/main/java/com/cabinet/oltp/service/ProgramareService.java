package com.cabinet.oltp.service;

import com.cabinet.oltp.dto.ProgramareDto;
import com.cabinet.oltp.entity.Medic;
import com.cabinet.oltp.entity.Pacient;
import com.cabinet.oltp.entity.Programare;
import com.cabinet.oltp.entity.Serviciu;
import com.cabinet.oltp.exceptions.ResourceNotFoundException;
import com.cabinet.oltp.repository.MedicRepository;
import com.cabinet.oltp.repository.PacientRepository;
import com.cabinet.oltp.repository.ProgramareRepository;
import com.cabinet.oltp.repository.ServiciuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramareService {

    private final ProgramareRepository programareRepository;
    private final PacientRepository pacientRepository;
    private final MedicRepository medicRepository;
    private final ServiciuRepository serviciuRepository;
    private final ModelMapper modelMapper;

    public ProgramareService(
            ProgramareRepository programareRepository,
            MedicRepository medicRepository,
            ServiciuRepository serviciuRepository,
            PacientRepository pacientRepository) {
        this.programareRepository = programareRepository;
        this.medicRepository = medicRepository;
        this.serviciuRepository = serviciuRepository;
        this.pacientRepository = pacientRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<Programare> findAll() {
        return programareRepository.findAll(Sort.by("idProgramare").ascending());
    }

    public void saveProgramare(ProgramareDto programareDto) {
        Programare programareEntity = new Programare();
        Pacient pacient =
                pacientRepository
                        .findById(programareDto.getIdPacient())
                        .orElseThrow(() -> new RuntimeException("Pacient negăsit!"));
        programareEntity.setPacient(pacient);

        Medic medic =
                medicRepository
                        .findById(programareDto.getIdMedic())
                        .orElseThrow(() -> new RuntimeException("Medic negăsit!"));
        programareEntity.setMedic(medic);

        Serviciu serviciu =
                serviciuRepository
                        .findById(programareDto.getIdServiciu())
                        .orElseThrow(() -> new RuntimeException("Serviciu negăsit!"));
        programareEntity.setServiciu(serviciu);
        programareEntity.setDataOra(programareDto.getDataOra());
        programareRepository.save(programareEntity);
    }

    public void deleteProgramareById(Long id) {
        programareRepository.deleteById(id);
    }

    public ProgramareDto findProgramareById(Long id) {
        Programare programare =
                programareRepository
                        .findById(id)
                        .orElseThrow(
                                () ->
                                        new ResourceNotFoundException(
                                                "Programarea cu id " + id + " nu a fost găsită!"));

        ProgramareDto programareDto = new ProgramareDto();
        programareDto.setIdProgramare(programare.getIdProgramare());
        programareDto.setIdPacient(programare.getPacient().getIdPacient());
        programareDto.setIdMedic(programare.getMedic().getIdAngajat());
        programareDto.setIdServiciu(programare.getServiciu().getIdServiciu());
        programareDto.setDataOra(programare.getDataOra());

        return programareDto;
    }

    public void updateProgramare(Long id, ProgramareDto dto) {
        Programare programare =
                programareRepository
                        .findById(id)
                        .orElseThrow(
                                () ->
                                        new ResourceNotFoundException(
                                                "Programarea cu id " + id + " nu a fost găsită!"));

        Pacient pacient =
                pacientRepository
                        .findById(dto.getIdPacient())
                        .orElseThrow(() -> new RuntimeException("Pacient negăsit!"));
        programare.setPacient(pacient);

        Medic medic =
                medicRepository
                        .findById(dto.getIdMedic())
                        .orElseThrow(() -> new RuntimeException("Medic negăsit!"));
        programare.setMedic(medic);

        Serviciu serviciu =
                serviciuRepository
                        .findById(dto.getIdServiciu())
                        .orElseThrow(() -> new RuntimeException("Serviciu negăsit!"));
        programare.setServiciu(serviciu);

        programare.setDataOra(dto.getDataOra());

        programareRepository.save(programare);
    }
}
