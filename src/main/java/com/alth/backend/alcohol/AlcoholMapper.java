package com.alth.backend.alcohol;

import com.alth.backend.alcohol.dto.response.AlcoholResponseDto;
import com.alth.backend.alcohol.dto.response.AlcoholResponseIdDto;
import com.alth.backend.alcohol.dto.response.AlcoholResponseListDto;
import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.alcohol.dto.request.AlcoholRequestDto;
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

    public AlcoholResponseDto fromEntity(Alcohol alcohol){
        return AlcoholResponseDto.builder()
                .alcoholId(alcohol.getAlcoholId())
                .alcoholName(alcohol.getAlcoholName())
                .degree(alcohol.getDegree())
                .price(alcohol.getPrice())
                .alCnt(alcohol.getAlCnt())
                .volume(alcohol.getVolume())
                .alcoholType(alcohol.getAlcoholType())
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
                .recordId(alcohol.getRecord().getRecordId())
                .alcoholName(alcohol.getAlcoholName())
                .degree(alcohol.getDegree())
                .price(alcohol.getPrice())
                .alCnt(alcohol.getAlCnt())
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
