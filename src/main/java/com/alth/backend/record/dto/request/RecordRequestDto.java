package com.alth.backend.record.dto.request;

import com.alth.backend.alcohol.dto.request.AlcoholRequestDto;
import com.alth.backend.record.domain.Feel;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordRequestDto {
    private Feel hangOver;
    private String recordMemo;
    private LocalDate recordDate;
    private List<AlcoholRequestDto> alcoholRequest;
}
