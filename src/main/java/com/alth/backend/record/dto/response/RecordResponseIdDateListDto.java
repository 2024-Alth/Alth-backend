package com.alth.backend.record.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordResponseIdDateListDto {
    private List<RecordResponseIdDateDto> recordList;
    // return RecordResponseIdDateDto by List type
}
