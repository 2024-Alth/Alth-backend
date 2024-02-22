package com.alth.backend.alcohol.repository;

import com.alth.backend.alcohol.domain.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {
    @Query("select a from Alcohol a where a.record.recordId = :id")
    List<Alcohol> findAlcoholEachRecord(@Param("id") Long id);

}
