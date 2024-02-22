package com.alth.backend.record.dto.response;

import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.record.domain.Feel;
import com.alth.backend.record.domain.Record;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecordResponseDto {

    private Long recordId;
    private int totalCnt;
    private Feel hangOver;
    private String recordMemo;
    private List<Alcohol> alcohols;

    private LocalDateTime recordWriteTime;
    private LocalDateTime recordEditTime;

    public RecordResponseDto(Record record) {
        this.recordId = record.getRecordId();
        this.totalCnt = record.getTotalCnt();
        this.hangOver = record.getHangOver();
        this.recordMemo = record.getRecordMemo();
        this.alcohols = record.getAlcohols();
        this.recordWriteTime = record.getCreatedAt();
        this.recordEditTime = record.getUpdatedAt();
    }
}
