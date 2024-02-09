package com.alth.backend.record.dto.response;

import com.alth.backend.record.domain.Alcohol;
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
    private int volume;
    private Alcohol.Type alcoholType;

    public AlcoholResponseDto(Alcohol alcohol) {
        this.alcoholId = alcohol.getAlcoholId();
        this.record = alcohol.getRecord();
        this.alcoholName = alcohol.getAlcoholName();
        this.degree = alcohol.getDegree();
        this.price = alcohol.getPrice();
        this.volume = alcohol.getVolume();
        this.alcoholType = alcohol.getAlcoholType();
    }
}
