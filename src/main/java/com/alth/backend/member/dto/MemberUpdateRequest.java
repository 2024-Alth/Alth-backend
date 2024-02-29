package com.alth.backend.member.dto;

import com.alth.backend.member.domain.EnjoyDrink;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Schema(description = "Member update request")
public class MemberUpdateRequest {
    @NotNull
    @Schema(description = "사용자 생년월일", nullable = false, example = "201223")
    private int birth;
    @NotBlank
    @Schema(description = "사용자 별명", nullable = false, example = "술찌")
    private String nickname;
    @NotBlank
    @Schema(description = "사용자 이름", nullable = false, example = "정우혁")
    private String name;
    @NotNull
    @Schema(description = "사용자 음주, 금주(절주) 여부", nullable = false, example = "NONDRINK")
    private EnjoyDrink enjoyDrink;
    @NotBlank
    @Schema(description = "사용자 선호 주류", nullable = false, example = "맥주")
    private String favorLiquor;
}
