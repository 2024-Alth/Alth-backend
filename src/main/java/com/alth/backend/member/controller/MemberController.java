package com.alth.backend.member.controller;

import com.alth.backend.config.security.jwt.JwtFilter;
import com.alth.backend.config.security.jwt.TokenProvider;
import com.alth.backend.member.dto.*;
import com.alth.backend.member.service.MemberService;
import com.alth.backend.post.dto.PostResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Member", description = "Member API")
public class MemberController {

    private final MemberService memberService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/signIn")
    @Operation(summary = "member signIn", description = "회원가입을 한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<String> signIn(@Valid @RequestBody MemberSignInRequest request) {

        return ResponseEntity.ok(memberService.signIn(request));
    }

    @PostMapping("/login")
    @Operation(summary = "member login", description = "회원이 로그인을 한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<TokenDto> login(@Valid @RequestBody MemberLoginRequest request) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/mypage")
    @Operation(summary = "member login", description = "회원정보를 조회 한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<MemberResponse> getMemberInfo() {
        return ResponseEntity.ok(memberService.getMemberInfo());
    }

    @PutMapping("/mypage")
    @Operation(summary = "member update", description = "회원이 정보를 수정한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<MemberResponse> updateMember(@Valid @RequestBody MemberUpdateRequest request) {
        return ResponseEntity.ok(memberService.update(request));
    }

    @DeleteMapping("/mypage")
    @Operation(summary = "member delete", description = "회원 탈퇴릃 한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<String> deleteMember() {
        return ResponseEntity.ok(memberService.delete());
    }

    @GetMapping("/mypage/posts")
    @Operation(summary = "Member Find MyPost", description = "회원이 자신이 작성한 게시물을 열람한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<List<PostResponse>> getMyPosts() {

        return ResponseEntity.ok(memberService.getMemberPosts());
    }
}
