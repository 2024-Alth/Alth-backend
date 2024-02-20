package com.alth.backend.record.dto.request;

import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.response.AlcoholResponseListDto;
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
    private Record.Feels hangOver;
    private String recordMemo;
    private List<AlcoholRequestDto> alcoholRequest = new ArrayList<>();
    private List<AlcoholResponseListDto> alcoholResponseListDto = new ArrayList<>();
}
