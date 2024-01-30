package com.alth.backend.record.dto.request;

import com.alth.backend.record.domain.Record;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordUpdateDto {
    private Long recordId;
    private int alCnt;
    private Record.Feels hangOver;
    private String recordMemo;
}
