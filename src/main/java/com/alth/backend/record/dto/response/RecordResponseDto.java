package com.alth.backend.record.dto.response;

import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.alcohol.dto.response.AlcoholResponseDto;
import com.alth.backend.record.domain.Feel;
import com.alth.backend.record.domain.Record;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RecordResponseDto {

    private Long recordId;
    private Feel hangOver;
    private String recordMemo;
    private List<AlcoholResponseDto> alcohols;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordWriteTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recordEditTime;

    public RecordResponseDto(Record record) {
        this.recordId = record.getRecordId();
        this.hangOver = record.getHangOver();
        this.recordMemo = record.getRecordMemo();
        this.alcohols = record.getAlcohols().stream()
                .map(AlcoholResponseDto::new)
                .collect(Collectors.toList());
        this.recordWriteTime = record.getCreatedAt();
        this.recordEditTime = record.getUpdatedAt();
    }
}
