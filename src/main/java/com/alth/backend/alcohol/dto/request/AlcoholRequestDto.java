package com.alth.backend.alcohol.dto.request;

import com.alth.backend.alcohol.domain.Types;
import lombok.*;

//@Builder
@Getter
@NoArgsConstructor
//@AllArgsConstructor
public class AlcoholRequestDto {
    private String alcoholName;
    private Double degree;
    private int price;
    private int alCnt;
    private int volume;
    private Types alcoholType;
    private Long recordId;
}
