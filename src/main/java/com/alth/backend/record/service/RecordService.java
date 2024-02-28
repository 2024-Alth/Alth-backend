package com.alth.backend.record.service;

import com.alth.backend.alcohol.dto.response.AlcoholResponseListDto;
import com.alth.backend.alcohol.AlcoholMapper;
import com.alth.backend.record.RecordMapper;
import com.alth.backend.alcohol.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import com.alth.backend.alcohol.dto.request.AlcoholRequestDto;
import com.alth.backend.record.dto.response.*;
import com.alth.backend.record.dto.request.RecordRequestDto;
import com.alth.backend.record.dto.request.RecordUpdateDto;
import com.alth.backend.alcohol.repository.AlcoholRepository;
import com.alth.backend.record.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final AlcoholRepository alcoholRepository;
    private final RecordMapper recordMapper;
    private final AlcoholMapper alcoholMapper;

    //C
    @Transactional
    public RecordResponseDto createRecordWithAlcohol(RecordRequestDto request){
        Record record = Record.builder()
                .hangOver(request.getHangOver())
                .recordMemo(request.getRecordMemo())
                .recordDate(request.getRecordDate())
                .recordDate(request.getRecordDate())
                .build();

        Record savedRecord = recordRepository.save(record);

        List<Alcohol> alcohols = request.getAlcoholRequest().stream()
                .map(dto -> new Alcohol(savedRecord, dto.getAlcoholName(), dto.getDegree(),
                        dto.getPrice(), dto.getAlCnt(), dto.getVolume(), dto.getAlcoholType()))
                .collect(Collectors.toList());


        alcoholRepository.saveAll(alcohols);


        return recordMapper.fromEntity(savedRecord);
    }


    //R - List
    public RecordResponseListDto findAll(){
        List<Record> records = recordRepository.findAll();

        return recordMapper.toListResponse(records);
    }

    //R - each of Record
    public RecordResponseDto findOneRecord(Long id){
        Record record = recordRepository.findById(id)
                .orElseThrow(IllegalStateException::new); // exception


        return recordMapper.toResponse(record);
    }

    // R - List of Alcohol in One Record
    public AlcoholResponseListDto findAlcoholEachRecord(Long id){
        Record record = recordRepository.findById(id)
                .orElseThrow(IllegalStateException::new); // exception

        List<Alcohol> alcohols = alcoholRepository.findAlcoholEachRecord(id);

        return recordMapper.toAlcoholsListResponse(alcohols);
    }

    //U
    @Transactional
    public RecordResponseDto updateRecord(RecordUpdateDto request, Long recId){
        recId = request.getRecordId(); // recordId in recId - for uri mapping(in Record Update)

        Record record = recordRepository.findById(request.getRecordId()) //find
                .orElseThrow(IllegalStateException::new); // exception

        record.updateRecord(request.getHangOver(), request.getRecordMemo(), request.getRecordDate()); // update


        Record savedRecord = recordRepository.save(record);

        return recordMapper.toResponse(savedRecord);
    }

    //D
    @Transactional
    public RecordResponseDto deleteRecord(Long id){
       Record record = recordRepository.findById(id) //find
               .orElseThrow(IllegalStateException::new); // exception
        record.delete();    //delete with Alcohol


        return recordMapper.toResponse(record);
    }
}
