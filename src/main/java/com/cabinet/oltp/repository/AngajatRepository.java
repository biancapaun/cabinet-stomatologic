package com.cabinet.oltp.repository;

import com.cabinet.oltp.entity.Angajat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AngajatRepository extends JpaRepository<Angajat, Long> {

    @Query(value = "SELECT a from Angajat a join fetch a.departament")
    List<Angajat> findAllEmployersWithDepartments();
}
