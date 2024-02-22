package com.alth.backend.member.service;

import com.alth.backend.config.security.SecurityUtil;
import com.alth.backend.member.MemberMapper;
import com.alth.backend.member.MemberRepository;
import com.alth.backend.member.domain.Member;
import com.alth.backend.member.dto.MemberResponse;
import com.alth.backend.member.dto.MemberSignInRequest;
import com.alth.backend.member.dto.MemberUpdateRequest;
import com.alth.backend.post.PostMapper;
import com.alth.backend.post.domain.Post;
import com.alth.backend.post.dto.PostResponse;
import com.alth.backend.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final PostRepository postRepository;
    private final PostMapper postMapper;

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
    public MemberResponse getMemberInfo() {
        return memberMapper.toResponse(
                SecurityUtil.getCurrentUsername()
                        .flatMap(memberRepository::findOneWithAuthoritiesByEmail)
                        .orElseThrow(() -> new RuntimeException("조회하지 못했습니다."))
        );
    }

    public Member getMember() {
        return SecurityUtil.getCurrentUsername()
                .flatMap(memberRepository::findOneWithAuthoritiesByEmail)
                .orElseThrow(() -> new RuntimeException("조회하지 못했습니다"));
    }

    @Transactional
    public MemberResponse update(MemberUpdateRequest request) {

        Member member = getMember();
        member.update(request.getNickname(), request.getBirth(), request.getName(),
                request.getEnjoyDrink(), request.getFavorLiquor());

        return memberMapper.toResponse(member);
    }

    public String delete() {
        Member member = getMember();

        memberRepository.delete(member);
        return "탈퇴되었습니다.";
    }

    public List<PostResponse> getMemberPosts() {
        Member member = getMember();

        List<Post> posts = postRepository.findAllByMember(member);
        return postMapper.toListResponse(posts);
    }
}
