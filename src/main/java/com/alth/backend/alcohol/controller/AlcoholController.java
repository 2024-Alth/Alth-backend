package com.alth.backend.alcohol.controller;

import com.alth.backend.alcohol.dto.request.AlcoholRequestDto;
import com.alth.backend.alcohol.dto.request.AlcoholUpdateDto;
import com.alth.backend.alcohol.dto.response.AlcoholResponseDto;
import com.alth.backend.alcohol.service.AlcoholService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AlcoholController {
    private final AlcoholService alcoholService;

    @PostMapping("/user/alcohol") // C
    public ResponseEntity<AlcoholResponseDto> createAlcohol(@RequestBody AlcoholRequestDto request){
        AlcoholResponseDto response = alcoholService.createAlcohol(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/alcohol/{id}") // R
    public ResponseEntity<AlcoholResponseDto> findOneAlcohol(@PathVariable Long id){
        return ResponseEntity.ok(alcoholService.findOneAlcohol(id));
    }

    @PutMapping("/user/alcohol/{alcId}") // U
    public ResponseEntity<AlcoholResponseDto> updateAlcohol(@RequestBody AlcoholUpdateDto request, @PathVariable Long alcId){
        return ResponseEntity.ok(alcoholService.updateAlcohol(request, alcId));
    }

    @DeleteMapping("/user/alcohol/{id}") // D
    public ResponseEntity<AlcoholResponseDto> deleteAlcohol(@PathVariable Long id){
        return ResponseEntity.ok(alcoholService.deleteAlcohol(id));
    }
}
