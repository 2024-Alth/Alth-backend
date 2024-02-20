package com.alth.backend.record.dto.request;

import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.response.AlcoholResponseListDto;
import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordUpdateDto {
    private Long recordId;
    private int totalCnt;
    private Record.Feels hangOver;
    private String recordMemo;
    private List<Alcohol> alcohols;
    private List<AlcoholRequestDto> alcoholRequest;
    private List<AlcoholResponseListDto> alcoholResponseListDto;
}
