package com.alth.backend.record;

import com.alth.backend.alcohol.dto.response.AlcoholResponseDto;
import com.alth.backend.alcohol.dto.response.AlcoholResponseListDto;
import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.response.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecordMapper {

    public RecordResponseDto fromEntity(Record record){
        List<AlcoholResponseDto> alcoholResponseDtos = record.getAlcohols()
                .stream()
                .map(alcohol -> new AlcoholResponseDto(alcohol))
                .collect(Collectors.toList());

        return RecordResponseDto.builder()
                .recordId(record.getRecordId())
                .hangOver(record.getHangOver())
                .recordMemo(record.getRecordMemo())
                .recordDate(record.getRecordDate())
                .alcohols(alcoholResponseDtos)
                .build();
    }


    public RecordResponseDto toResponse(Record record){
            List<AlcoholResponseDto> alcoholResponseDtos = record.getAlcohols()
                    .stream()
                    .map(alcohol -> new AlcoholResponseDto(alcohol))
                    .collect(Collectors.toList());

        return RecordResponseDto.builder()
                .recordId(record.getRecordId())
                .hangOver(record.getHangOver())
                .recordMemo(record.getRecordMemo())
                .recordDate(record.getRecordDate())
                .alcohols(alcoholResponseDtos)
                .build();
    }

    public RecordResponseIdDateDto toIdDateResponse(Record record){

        return RecordResponseIdDateDto.builder()
                .recordId(record.getRecordId())
                .recordDate(record.getRecordDate())
                .build();
    }

    public RecordResponseListDto toListResponse(List<Record> recordList){
        List<RecordResponseDto> recordResponseList
                = recordList.stream().map(this::toResponse).collect(Collectors.toList());

        return RecordResponseListDto.builder().recordList(recordResponseList).build();
    }

    public RecordResponseIdDateListDto toListIdDateResponse(List<Record> recordList){
        List<RecordResponseIdDateDto> recordResponseList
                = recordList.stream().map(this::toIdDateResponse).collect(Collectors.toList());

        return RecordResponseIdDateListDto.builder().recordList(recordResponseList).build();
    }

    public AlcoholResponseListDto toAlcoholsListResponse(List<Alcohol> alcoholList){
        List<AlcoholResponseDto> alcoholResponseList
                = alcoholList.stream().map(this::toAlcoholResponse).collect(Collectors.toList());

        return AlcoholResponseListDto.builder().alcoholList(alcoholResponseList).build();

    }

    public AlcoholResponseDto toAlcoholResponse(Alcohol alcohol){
        return AlcoholResponseDto.builder()
                .alcoholId(alcohol.getAlcoholId())
                .recordId(alcohol.getRecord().getRecordId())
                .alcoholName(alcohol.getAlcoholName())
                .degree(alcohol.getDegree())
                .price(alcohol.getPrice())
                .alCnt(alcohol.getAlCnt())
                .volume(alcohol.getVolume())
                .alcoholType(alcohol.getAlcoholType())
                .build();

    }
}
