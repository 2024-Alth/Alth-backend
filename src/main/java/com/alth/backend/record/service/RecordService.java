package com.alth.backend.record.service;


import com.alth.backend.record.RecordMapper;
import com.alth.backend.record.domain.Record;
import com.alth.backend.record.dto.response.RecordResponseDto;
import com.alth.backend.record.dto.response.RecordResponseIdDto;
import com.alth.backend.record.dto.response.RecordResponseListDto;
import com.alth.backend.record.dto.request.RecordRequestDto;
import com.alth.backend.record.dto.request.RecordUpdateDto;
import com.alth.backend.record.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;

    //C
    public RecordResponseIdDto createRecord(RecordRequestDto request){
        Record record = recordRepository.save(recordMapper.toEntity(request)); //save
        RecordResponseIdDto recordResponseIdDto = recordMapper.toResponseId(record); //ret

        return recordResponseIdDto;
    }

    //R - List
    public RecordResponseListDto findAll(){
        List<Record> records = recordRepository.findAll();

        return recordMapper.toListResponse(records);
    }

    //R
    public RecordResponseDto findOneRecord(Long id){
        Record record = recordRepository.findById(id)
                .orElseThrow(IllegalStateException::new); // exception

        return recordMapper.toResponse(record);
    }

    //U
    @Transactional
    public RecordResponseDto updateRecord(RecordUpdateDto request){
        Record record = recordRepository.findById(request.getRecordId()) //find
                .orElseThrow(IllegalStateException::new); // exception

        record.updateRecord(record.getAlCnt(), record.getHangOver(), record.getRecordMemo()); // update

        return recordMapper.toResponse(record);
    }

    //D
    @Transactional
    public RecordResponseDto deleteRecord(Long id){
       Record record = recordRepository.findById(id) //find
               .orElseThrow(IllegalStateException::new); // exception
        record.delete();    //delete

        return recordMapper.toResponse(record);
    }
}
