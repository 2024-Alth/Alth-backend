package com.alth.backend.record.dto.request;

import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import lombok.*;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordRequestDto {
    private int alCnt;
    private Record.Feels hangOver;
    private String recordMemo;
    private List<Alcohol> alcohols;
}
