package com.cabinet.oltp.repository;

import com.cabinet.oltp.entity.Serviciu;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiciuRepository extends JpaRepository<Serviciu, Long> {

    @Query(value = "SELECT s from Serviciu s join fetch s.categorie")
    List<Serviciu> findAllServiciesWithCategories(Sort idPacient);
}
