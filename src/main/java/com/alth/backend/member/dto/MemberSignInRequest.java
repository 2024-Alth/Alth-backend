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

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Member signIn request")
public class MemberSignInRequest {
    @Email
    @NotBlank
    @Schema(description = "사용자 이메일", nullable = false, example = "mr6208@naver.com")
    private String email;

    @NotBlank
    @Schema(description = "사용자 비밀번호", nullable = false, example = "asdf1020")
    private String password;

    @NotBlank
    @Schema(description = "사용자 이름", nullable = false, example = "우혁정")
    private String name;

    @NotBlank
    @Schema(description = "사용자 별명", nullable = false, example = "코린이")
    private String nickname;

    @NotNull
    @Schema(description = "사용자 생년월일", nullable = false, example = "981223")
    private int birth;

    @NotNull
    @Schema(description = "사용자 음주, 금주(절주) 여부", nullable = false, example = "DRINK")
    private EnjoyDrink enjoyDrink;

    @NotBlank
    @Schema(description = "사용자 선호 주류", nullable = false, example = "소주")
    private String favorLiquor;
}
