package com.alth.backend.member;

import com.alth.backend.member.domain.Authority;
import com.alth.backend.member.domain.Member;
import com.alth.backend.member.dto.MemberResponse;
import com.alth.backend.member.dto.MemberSignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class MemberMapper {

    private final PasswordEncoder passwordEncoder;

    public Member toEntity(MemberSignInRequest request) {

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Member member = Member.builder()
                .authorities(Collections.singleton(authority))
                .birth(request.getBirth())
                .email(request.getEmail())
                .enjoyDrink(request.getEnjoyDrink())
                .favorLiquor(request.getFavorLiquor())
                .name(request.getName())
                .nickname(request.getNickname())
                .activated(true)
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        return member;
    }

    public MemberResponse toResponse(Member member) {
        if(member == null) return null;

        return MemberResponse.builder()
                .nickname(member.getNickname())
                .birth(member.getBirth())
                .name(member.getName())
                .favorLiquor(member.getFavorLiquor())
                .email(member.getEmail())
                .enjoyDrink(member.getEnjoyDrink().getKorean())
                .build();
    }
}
