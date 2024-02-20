package com.alth.backend.record.dto.request;

import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private Alcohol.Type alcoholType;
}
