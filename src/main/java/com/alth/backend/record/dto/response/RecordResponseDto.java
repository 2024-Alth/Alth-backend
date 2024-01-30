package com.alth.backend.record.dto.response;

import com.alth.backend.record.domain.Record;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecordResponseDto {

    private Long recordId;
    private int alCnt;
    private Record.Feels hangOver;
    private String recordMemo;

    private LocalDateTime recordWriteTime;
    private LocalDateTime recordEditTime;

    public RecordResponseDto(Record record) {
        this.recordId = record.getRecordId();
        this.alCnt = record.getAlCnt();
        this.hangOver = record.getHangOver();
        this.recordMemo = record.getRecordMemo();
        this.recordWriteTime = record.getCreatedAt();
        this.recordEditTime = record.getUpdatedAt();
    }
}
