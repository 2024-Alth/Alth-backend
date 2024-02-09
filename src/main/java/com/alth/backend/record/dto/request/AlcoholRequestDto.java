package com.alth.backend.record.dto.request;

import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlcoholRequestDto {
    private String alcoholName;
    private Double degree;
    private int price;
    private int volume;
    private Alcohol.Type alcoholType;
}
