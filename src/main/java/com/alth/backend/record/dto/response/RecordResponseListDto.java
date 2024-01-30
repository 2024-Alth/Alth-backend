package com.alth.backend.record.dto.response;

import com.alth.backend.record.dto.response.RecordResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecordResponseListDto {
    private List<RecordResponseDto> recordList;
    // return RecordResponseDto by List type
}
