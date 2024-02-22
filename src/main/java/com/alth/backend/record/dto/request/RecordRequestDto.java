package com.alth.backend.record.dto.request;

import com.alth.backend.Alcohol.dto.request.AlcoholRequestDto;
import com.alth.backend.record.domain.Feel;
import com.alth.backend.record.domain.Record;
import com.alth.backend.Alcohol.dto.response.AlcoholResponseListDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordRequestDto {
    private int totalCnt;
    private Feel hangOver;
    private String recordMemo;
    private List<AlcoholRequestDto> alcoholRequest = new ArrayList<>();
}
