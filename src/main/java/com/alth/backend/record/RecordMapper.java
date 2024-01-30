package com.alth.backend.record;

import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.response.RecordResponseDto;
import com.alth.backend.record.dto.response.RecordResponseIdDto;
import com.alth.backend.record.dto.response.RecordResponseListDto;
import com.alth.backend.record.dto.request.RecordRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecordMapper {

    public Record toEntity(RecordRequestDto request){
        return Record.builder()
                .alCnt(request.getAlCnt())
                .hangOver(request.getHangOver())
                .recordMemo(request.getRecordMemo())
                .build();
    }

    public RecordResponseIdDto toResponseId(Record record){
        return RecordResponseIdDto.builder()
                .id(record.getRecordId())
                .build();
    }

    public RecordResponseDto toResponse(Record record){
        return RecordResponseDto.builder()
                .recordId(record.getRecordId())
                .alCnt(record.getAlCnt())
                .hangOver(record.getHangOver())
                .recordMemo(record.getRecordMemo())
                .recordWriteTime(record.getCreatedAt())
                .recordEditTime(record.getUpdatedAt())
                .build();
    }

    public RecordResponseListDto toListResponse(List<Record> recordList){
        List<RecordResponseDto> recordResponseList
                = recordList.stream().map(this::toResponse).collect(Collectors.toList());

        return RecordResponseListDto.builder().recordList(recordResponseList).build();
    }
}
