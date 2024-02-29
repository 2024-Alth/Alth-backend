package com.alth.backend.alcohol.dto.request;

import com.alth.backend.alcohol.domain.Types;
import com.alth.backend.record.domain.Record;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlcoholUpdateDto {
    private Long alcoholId;
    private Record record;
    private String alcoholName;
    private Double degree;
    private int price;
    private int alCnt;
    private int volume;
    private Types alcoholType;
}
