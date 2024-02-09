package com.alth.backend.record.repository;

import com.alth.backend.record.domain.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

    @Query()
    List<Alcohol> findAlcoholEachRecord(Long id);
    Optional<Alcohol> findByRecId(Long id);

}
