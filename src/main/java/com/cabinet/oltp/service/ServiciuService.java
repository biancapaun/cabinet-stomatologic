package com.cabinet.oltp.service;

import com.cabinet.oltp.dto.ServiciuDto;
import com.cabinet.oltp.entity.Categorie;
import com.cabinet.oltp.entity.Serviciu;
import com.cabinet.oltp.exceptions.ResourceNotFoundException;
import com.cabinet.oltp.repository.AngajatRepository;
import com.cabinet.oltp.repository.CategorieRepository;
import com.cabinet.oltp.repository.ServiciuRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiciuService {

    private final ServiciuRepository serviciuRepository;
    private final ModelMapper modelMapper;
    private final CategorieRepository categorieRepository;

    public ServiciuService(
            AngajatRepository angajatRepository,
            ServiciuRepository serviciuRepository,
            ModelMapper modelMapper,
            CategorieRepository categorieRepository) {
        this.serviciuRepository = serviciuRepository;
        this.modelMapper = modelMapper;
        this.categorieRepository = categorieRepository;
    }

    public List<Serviciu> findAll() {
        return serviciuRepository.findAllServiciesWithCategories();
    }

    public void saveServiciu(ServiciuDto serviciuDto) {
        Serviciu serviciuEntity = new Serviciu();
        Categorie categorie =
                categorieRepository
                        .findById(serviciuDto.getIdCategorie())
                        .orElseThrow(() -> new RuntimeException("Categoria nu a fost găsită!"));
        serviciuEntity.setDenumire(serviciuDto.getDenumire());
        serviciuEntity.setCategorie(categorie);
        serviciuEntity.setPret(serviciuDto.getPret());
        serviciuRepository.save(serviciuEntity);
    }

    public void deleteServiciuById(Long id) {
        serviciuRepository.deleteById(id);
    }

    public ServiciuDto findServiciuById(Long id) {
        Serviciu serviciu =
                serviciuRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("Serviciul cu id " + id + " nu a fost găsit!"));

        ServiciuDto serviciuDto = new ServiciuDto();
        serviciuDto.setIdServiciu(serviciu.getIdServiciu());
        serviciuDto.setIdCategorie(serviciu.getCategorie().getIdCategorie());
        serviciuDto.setDenumire(serviciu.getDenumire());
        serviciuDto.setPret(serviciu.getPret());
        return serviciuDto;
    }

    public void updateServiciu(Long id, ServiciuDto dto) {
        Serviciu serviciu =
                serviciuRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("Serviciul cu id " + id + " nu a fost găsit!"));

        Categorie categorie =
                categorieRepository
                        .findById(dto.getIdCategorie())
                        .orElseThrow(() -> new RuntimeException("Categoria nu a fost găsită!"));
        serviciu.setCategorie(categorie);
        serviciu.setDenumire(dto.getDenumire());
        serviciu.setPret(dto.getPret());
        serviciuRepository.save(serviciu);
    }
}
