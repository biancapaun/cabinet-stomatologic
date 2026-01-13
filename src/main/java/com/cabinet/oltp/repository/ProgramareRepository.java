package com.cabinet.oltp.repository;

import com.cabinet.oltp.entity.Programare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramareRepository extends JpaRepository<Programare, Long> {
}
