package com.cabinet.oltp.repository;

import com.cabinet.oltp.entity.Incasare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncasareRepository extends JpaRepository<Incasare, Long> {
}
