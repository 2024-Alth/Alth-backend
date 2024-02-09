package com.alth.backend.post.service;

import com.alth.backend.member.domain.EnjoyDrink;
import com.alth.backend.member.domain.Member;
import com.alth.backend.member.service.MemberService;
import com.alth.backend.post.PostMapper;
import com.alth.backend.post.repository.PostRepository;
import com.alth.backend.post.domain.Post;
import com.alth.backend.post.dto.PostCreateRequest;
import com.alth.backend.post.dto.PostList;
import com.alth.backend.post.dto.PostResponse;
import com.alth.backend.post.dto.PostUpdateRequest;
import com.alth.backend.post.validator.PostValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberService memberService;
    private final PostMapper postMapper;
    private final PostValidator postValidator;

    @Transactional
    public Long create(PostCreateRequest request) {
        Member member = memberService.getMember();

        Post post = postMapper.toEntity(request, member);

        postRepository.save(post);
        return post.getId();
    }

    public Page<PostList> getPostList(EnjoyDrink enjoyDrink, Pageable pageable) {
        Page<Post> posts = postRepository.findAllByEnjoyDrink(pageable, enjoyDrink);
        return postMapper.toPageListResponse(posts);
    }

    @Transactional
    public String update(PostUpdateRequest request, Long id) {

        Member member = memberService.getMember();

        Post post = postRepository.findByMemberAndId(member, id);
        postValidator.postExistValid(post);
        post.update(request.getTitle(), request.getContent());
        return "정상적으로 수정되었습니다.";
    }

    @Transactional
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(IllegalStateException::new);
        post.updateView();
        return postMapper.toResponse(post);
    }

    @Transactional
    public List<PostResponse> getPostSearch(String keyword) {
        List<Post> posts = postRepository.findAllSearch(keyword);
        return postMapper.toListResponse(posts);
    }
}
