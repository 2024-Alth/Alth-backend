package com.alth.backend.record.dto.response;

import com.alth.backend.record.domain.Record;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RecordResponseIdDateDto {

    private Long recordId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate recordDate;

    public RecordResponseIdDateDto(Record record) {
        this.recordId = record.getRecordId();
        this.recordDate = record.getRecordDate();
    }
}
