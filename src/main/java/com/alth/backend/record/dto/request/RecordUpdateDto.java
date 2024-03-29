package com.alth.backend.record.dto.request;

import com.alth.backend.alcohol.dto.request.AlcoholRequestDto;
import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.record.domain.Feel;
import com.alth.backend.alcohol.dto.response.AlcoholResponseListDto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordUpdateDto {
    private Long recordId;
    private Feel hangOver;
    private String recordMemo;
    private LocalDate recordDate;
}
