package com.alth.backend.Alcohol.dto.response;

import com.alth.backend.Alcohol.domain.Alcohol;
import com.alth.backend.Alcohol.domain.Types;
import com.alth.backend.record.domain.Record;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlcoholResponseDto {

    private Long alcoholId;
    private Record record;
    private String alcoholName;
    private Double degree;
    private int price;
    private int alCnt;
    private int volume;
    private Types alcoholType;

    public AlcoholResponseDto(Alcohol alcohol) {
        this.alcoholId = alcohol.getAlcoholId();
        this.record = alcohol.getRecord();
        this.alcoholName = alcohol.getAlcoholName();
        this.degree = alcohol.getDegree();
        this.price = alcohol.getPrice();
        this.alCnt = alcohol.getAlCnt();
        this.volume = alcohol.getVolume();
        this.alcoholType = alcohol.getAlcoholType();
    }
}
