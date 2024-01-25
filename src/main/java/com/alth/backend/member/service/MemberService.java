package com.alth.backend.member.service;

import com.alth.backend.config.security.SecurityUtil;
import com.alth.backend.member.MemberMapper;
import com.alth.backend.member.MemberRepository;
import com.alth.backend.member.domain.Member;
import com.alth.backend.member.dto.MemberResponse;
import com.alth.backend.member.dto.MemberSignInRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public String signIn(MemberSignInRequest request) {
        if (memberRepository.findOneWithAuthoritiesByEmail(request.getEmail()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 회원입니다.");
        }

        Member member = memberMapper.toEntity(request);
        memberRepository.save(member);

        return "회원가입이 완료되었습니다.";
    }

    @Transactional(readOnly = true)
    public MemberResponse getMember() {
        return memberMapper.toResponse(
                SecurityUtil.getCurrentUsername()
                        .flatMap(memberRepository::findOneWithAuthoritiesByEmail)
                        .orElseThrow(() -> new RuntimeException("조회하지 못했습니다."))
        );
    }
}
