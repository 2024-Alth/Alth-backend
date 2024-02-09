package com.alth.backend.record.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlcoholResponseListDto {
    private List<AlcoholResponseDto> alcoholList;
    // return AlcoholResponseDto by List type
}
