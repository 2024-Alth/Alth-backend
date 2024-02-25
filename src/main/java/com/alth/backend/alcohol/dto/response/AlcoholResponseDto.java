package com.alth.backend.alcohol.dto.response;

import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.alcohol.domain.Types;
import com.alth.backend.record.domain.Record;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
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
