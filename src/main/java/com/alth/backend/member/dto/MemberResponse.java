package com.alth.backend.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class MemberResponse {
    private String name;
    private String nickname;
    private String email;
    private int birth;
    private boolean enjoyDrink;
    private String favorLiquor;
}
