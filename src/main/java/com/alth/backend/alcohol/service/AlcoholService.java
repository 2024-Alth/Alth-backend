package com.alth.backend.alcohol.service;

import com.alth.backend.alcohol.AlcoholMapper;
import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.alcohol.dto.request.AlcoholRequestDto;
import com.alth.backend.alcohol.dto.request.AlcoholUpdateDto;
import com.alth.backend.alcohol.dto.response.AlcoholResponseDto;
import com.alth.backend.alcohol.repository.AlcoholRepository;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.repository.RecordRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlcoholService {
    private final AlcoholRepository alcoholRepository;
    private final RecordRepository recordRepository;
    private final AlcoholMapper alcoholMapper;

    // C
    @Transactional
    public AlcoholResponseDto createAlcohol(AlcoholRequestDto request){
        Record record = recordRepository.findById(request.getRecordId())
                .orElseThrow(() -> new EntityNotFoundException("Record not found with id: " + request.getRecordId()));

        Alcohol alcohol = Alcohol.builder()
                .alcoholName(request.getAlcoholName())
                .degree(request.getDegree())
                .price(request.getPrice())
                .alCnt(request.getAlCnt())
                .volume(request.getVolume())
                .alcoholType(request.getAlcoholType())
                .record(record)
                .build();

        Alcohol savedAlcohol = alcoholRepository.save(alcohol);

        return alcoholMapper.fromEntity(savedAlcohol);
    }

    // R
    @Transactional
    public AlcoholResponseDto findOneAlcohol(Long id){
        Alcohol alcohol = alcoholRepository.findById(id)
                .orElseThrow(IllegalStateException::new); // exception

        return alcoholMapper.toAlcoholResponse(alcohol);
    }

    // U
    @Transactional
    public AlcoholResponseDto updateAlcohol(AlcoholUpdateDto request, Long alcId){
        alcId = request.getAlcoholId(); // alcoholId in alcId - for uri mapping(in Alcohol Update)

        Alcohol alcohol = alcoholRepository.findById(request.getAlcoholId()) //find
                .orElseThrow(IllegalStateException::new); // exception

        alcohol.updateAlcohol(request.getAlcoholName(), request.getDegree(), request.getPrice(),
                request.getAlCnt(), request.getVolume(), request.getAlcoholType()); // update

        Alcohol savedAlcohol = alcoholRepository.save(alcohol);

        return alcoholMapper.toAlcoholResponse(savedAlcohol);

    }

    // D
    @Transactional
    public AlcoholResponseDto deleteAlcohol(Long id){
        Alcohol alcohol = alcoholRepository.findById(id) //find
                .orElseThrow(IllegalStateException::new); // exception
        alcohol.delete();

        return alcoholMapper.toAlcoholResponse(alcohol);
    }
}
