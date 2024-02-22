package com.alth.backend.Alcohol.dto.request;

import com.alth.backend.Alcohol.domain.Alcohol;
import com.alth.backend.Alcohol.domain.Types;
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
    private int alCnt;
    private int volume;
    private Types alcoholType;
}
