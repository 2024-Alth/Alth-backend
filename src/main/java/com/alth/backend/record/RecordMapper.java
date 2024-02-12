package com.alth.backend.record;

import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.request.AlcoholRequestDto;
import com.alth.backend.record.dto.response.*;
import com.alth.backend.record.dto.request.RecordRequestDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecordMapper {

    public Record toEntity(RecordRequestDto request){
        Record.RecordBuilder builder = Record.builder()
                .alCnt(request.getAlCnt())
                .hangOver(request.getHangOver())
                .recordMemo(request.getRecordMemo());

        List<Alcohol> alcoholsInMap = Collections.emptyList();
        List<AlcoholRequestDto> alcoholRequests = request.getAlcoholRequest();
        if (alcoholRequests != null) {
            alcoholsInMap = alcoholRequests.stream()
                    .map(alcoholRequestDto -> Alcohol.builder()
                            .alcoholName(alcoholRequestDto.getAlcoholName())
                            .degree(alcoholRequestDto.getDegree())
                            .price(alcoholRequestDto.getPrice())
                            .volume(alcoholRequestDto.getVolume())
                            .alcoholType(alcoholRequestDto.getAlcoholType())
                            .build())
                    .collect(Collectors.toList());
        }

        return builder.alcohols(alcoholsInMap).build();
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
                .alcoholList(record.getAlcohols())
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
