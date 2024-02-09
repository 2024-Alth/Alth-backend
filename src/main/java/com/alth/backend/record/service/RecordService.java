package com.alth.backend.record.service;

import com.alth.backend.record.AlcoholMapper;
import com.alth.backend.record.RecordMapper;
import com.alth.backend.record.domain.Alcohol;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.request.AlcoholUpdateDto;
import com.alth.backend.record.dto.response.*;
import com.alth.backend.record.dto.request.RecordRequestDto;
import com.alth.backend.record.dto.request.RecordUpdateDto;
import com.alth.backend.record.repository.AlcoholRepository;
import com.alth.backend.record.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final AlcoholRepository alcoholRepository;
    private final RecordMapper recordMapper;
    private final AlcoholMapper alcoholMapper;

    //C
    public RecordResponseIdDto createRecord(RecordRequestDto request){
        Record record = recordRepository.save(recordMapper.toEntity(request)); //save
        record.getAlcohols().forEach(alcohol -> alcohol.setRecord(record)); // set alcohol - recordId
        RecordResponseIdDto recordResponseIdDto = recordMapper.toResponseId(record); //ret

        return recordResponseIdDto;
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
        Alcohol alcohol = alcoholRepository.findByRecId(id)
                .orElseThrow(IllegalStateException::new);
        Long recId = alcohol.getRecord().getRecordId();

        List<Alcohol> alcohols = alcoholRepository.findAlcoholEachRecord(id);

        return alcoholMapper.toAlcoholsListResponse(alcohols);
    }

    //U
    @Transactional
    public RecordResponseDto updateRecord(RecordUpdateDto request, Long recId){
        recId = request.getRecordId(); // recordId in recId - for uri mapping(in Record Update)

        Record record = recordRepository.findById(request.getRecordId()) //find
                .orElseThrow(IllegalStateException::new); // exception

        record.updateRecord(request.getAlCnt(), request.getHangOver(), request.getRecordMemo()); // update

        return recordMapper.toResponse(record);
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
