package com.alth.backend.alcohol;

import com.alth.backend.alcohol.dto.response.AlcoholResponseDto;
import com.alth.backend.alcohol.domain.Alcohol;
import org.springframework.stereotype.Component;


@Component
public class AlcoholMapper {

    public AlcoholResponseDto fromEntity(Alcohol alcohol){
        return AlcoholResponseDto.builder()
                .alcoholId(alcohol.getAlcoholId())
                .alcoholName(alcohol.getAlcoholName())
                .degree(alcohol.getDegree())
                .price(alcohol.getPrice())
                .alCnt(alcohol.getAlCnt())
                .volume(alcohol.getVolume())
                .alcoholType(alcohol.getAlcoholType())
                .recordId(alcohol.getRecord().getRecordId())
                .build();
    }


    public AlcoholResponseDto toAlcoholResponse(Alcohol alcohol){
        return AlcoholResponseDto.builder()
                .alcoholId(alcohol.getAlcoholId())
                .recordId(alcohol.getRecord().getRecordId())
                .alcoholName(alcohol.getAlcoholName())
                .degree(alcohol.getDegree())
                .price(alcohol.getPrice())
                .alCnt(alcohol.getAlCnt())
                .volume(alcohol.getVolume())
                .alcoholType(alcohol.getAlcoholType())
                .build();

    }
}
