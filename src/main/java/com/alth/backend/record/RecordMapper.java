package com.alth.backend.record;

import com.alth.backend.Alcohol.dto.response.AlcoholResponseDto;
import com.alth.backend.Alcohol.dto.response.AlcoholResponseListDto;
import com.alth.backend.Alcohol.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.response.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecordMapper {

    public RecordResponseDto fromEntity(Record record){
        return RecordResponseDto.builder()
                .recordId(record.getRecordId())
                .totalCnt(record.getTotalCnt())
                .hangOver(record.getHangOver())
                .recordMemo(record.getRecordMemo())
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
                .totalCnt(record.getTotalCnt())
                .hangOver(record.getHangOver())
                .recordMemo(record.getRecordMemo())
                .alcohols(record.getAlcohols())
                .recordWriteTime(record.getCreatedAt())
                .recordEditTime(record.getUpdatedAt())
                .build();
    }

    public RecordResponseListDto toListResponse(List<Record> recordList){
        List<RecordResponseDto> recordResponseList
                = recordList.stream().map(this::toResponse).collect(Collectors.toList());

        return RecordResponseListDto.builder().recordList(recordResponseList).build();
    }

    public AlcoholResponseListDto toAlcoholsListResponse(List<Alcohol> alcoholList){
        List<AlcoholResponseDto> alcoholResponseList
                = alcoholList.stream().map(this::toAlcoholResponse).collect(Collectors.toList());

        return AlcoholResponseListDto.builder().alcoholList(alcoholResponseList).build();

    }

    public AlcoholResponseDto toAlcoholResponse(Alcohol alcohol){
        return AlcoholResponseDto.builder()
                .alcoholId(alcohol.getAlcoholId())
                .record(alcohol.getRecord())
                .alcoholName(alcohol.getAlcoholName())
                .degree(alcohol.getDegree())
                .price(alcohol.getPrice())
                .volume(alcohol.getVolume())
                .alcoholType(alcohol.getAlcoholType())
                .build();

    }
}
