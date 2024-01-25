package com.alth.backend.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Member login request")
public class MemberLoginRequest {
    @NotBlank
    @Email
    @Schema(description = "회원 이메일", nullable = false, example = "mr6208@naver.com")
    private String email;

    @NotBlank
    @Schema(description = "회원 비밀번호", nullable = false, example = "asdf1020")
    private String password;
}
