package com.alth.backend.record.repository;

import com.alth.backend.record.domain.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {
    @Query("select a from Alcohol a where a.record = :id")
    List<Alcohol> findAlcoholEachRecord(@Param("id") Long id);

    @Query("select a from Alcohol  a where a.record = :id")
    Optional<Alcohol> findByRecordId(Long id);

}
