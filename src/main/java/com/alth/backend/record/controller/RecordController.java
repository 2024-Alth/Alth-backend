package com.alth.backend.record.controller;

import com.alth.backend.record.dto.response.*;
import com.alth.backend.record.dto.request.RecordRequestDto;
import com.alth.backend.record.dto.request.RecordUpdateDto;
import com.alth.backend.record.repository.AlcoholRepository;
import com.alth.backend.record.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class RecordController {

    private final RecordService recordService;

    @PostMapping ("/user/record")  //C
    public ResponseEntity<RecordResponseIdDto> createRecord(@RequestBody RecordRequestDto request){
        return ResponseEntity.ok(recordService.createRecord(request));
    }

    @GetMapping ("/user/record") //R -  List
    public ResponseEntity<RecordResponseListDto> findAll(){
        return ResponseEntity.ok(recordService.findAll());
    }

    @GetMapping("/user/record/{id}")    //R - each of Record
    public ResponseEntity<RecordResponseDto> findOneRecord(@PathVariable Long id){
        return ResponseEntity.ok(recordService.findOneRecord(id));
    }

    @GetMapping("/user/record/{id}/alcohols") // R - List of Alcohol in One Record
    public ResponseEntity<AlcoholResponseListDto> findAlcoholEachRecord(@PathVariable Long id){
        return ResponseEntity.ok(recordService.findAlcoholEachRecord(id));
    }

    @PutMapping("/user/record/{recId}")    //U
    public ResponseEntity<RecordResponseDto> updateRecord(@RequestBody RecordUpdateDto request, @PathVariable Long recId){
        return ResponseEntity.ok(recordService.updateRecord(request, recId));
    }

    @DeleteMapping("/user/record/{id}") //D
    public ResponseEntity<RecordResponseDto> deleteRecord(@PathVariable Long id){
        return ResponseEntity.ok(recordService.deleteRecord(id));
    }
}
