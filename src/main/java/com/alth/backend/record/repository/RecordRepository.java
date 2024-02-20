package com.alth.backend.record.repository;

import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RecordRepository extends JpaRepository<Record, Long> {
    Record save(Record record);
    List<Record> findAll();
    Optional<Record> findById(Long id); // id - record Id

}
