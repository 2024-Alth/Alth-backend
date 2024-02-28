package com.alth.backend.record.dto.response;

import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.alcohol.dto.response.AlcoholResponseDto;
import com.alth.backend.record.domain.Feel;
import com.alth.backend.record.domain.Record;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate recordDate;

    public RecordResponseDto(Record record) {
        this.recordId = record.getRecordId();
        this.hangOver = record.getHangOver();
        this.recordMemo = record.getRecordMemo();
        this.recordDate = record.getRecordDate();
        this.alcohols = record.getAlcohols().stream()
                .map(AlcoholResponseDto::new)
                .collect(Collectors.toList());
    }
}
