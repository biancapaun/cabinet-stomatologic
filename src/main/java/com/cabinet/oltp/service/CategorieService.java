package com.cabinet.oltp.service;

import com.cabinet.oltp.entity.Categorie;
import com.cabinet.oltp.repository.CategorieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    private final CategorieRepository categorieRepository;
    private final ModelMapper modelMapper;

    public CategorieService(CategorieRepository categorieRepository, ModelMapper modelMapper) {
        this.categorieRepository = categorieRepository;
        this.modelMapper = modelMapper;
    }

    public List<Categorie> findAll() {
        return categorieRepository.findAll(Sort.by("idCategorie").ascending());
    }
}
