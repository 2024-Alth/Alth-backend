package com.alth.backend.record;

import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.request.AlcoholRequestDto;
import com.alth.backend.record.dto.request.RecordRequestDto;
import com.alth.backend.record.dto.response.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlcoholMapper {


    public Alcohol toAlcoholEntity(AlcoholRequestDto request){
        return Alcohol.builder()
                .alcoholName(request.getAlcoholName())
                .degree(request.getDegree())
                .price(request.getPrice())
                .volume(request.getVolume())
                .alcoholType(request.getAlcoholType())
                .build();
    }


    public AlcoholResponseIdDto toResponseAlcoholId(Alcohol alcohol){
        return AlcoholResponseIdDto.builder()
                .id(alcohol.getAlcoholId())
                .build();
    }


    public AlcoholResponseDto toAlcoholResponse(Alcohol alcohol){
        return AlcoholResponseDto.builder()
                .alcoholId(alcohol.getAlcoholId())
                .record(alcohol.getRecord())
                .alcoholName(alcohol.getAlcoholName())
                .degree(alcohol.getDegree())
                .price(alcohol.getPrice())
                .volume(alcohol.getVolume())
                .alcoholType(alcohol.getAlcoholType())
                .build();

    }

    public AlcoholResponseListDto toAlcoholsListResponse(List<Alcohol> alcoholList){
        List<AlcoholResponseDto> alcoholResponseList
                = alcoholList.stream().map(this::toAlcoholResponse).collect(Collectors.toList());

        return AlcoholResponseListDto.builder().alcoholList(alcoholResponseList).build();

    }
}
