package com.alth.backend.post;

import com.alth.backend.member.domain.Member;
import com.alth.backend.post.domain.Post;
import com.alth.backend.post.dto.PostCreateRequest;
import com.alth.backend.post.dto.PostList;
import com.alth.backend.post.dto.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class PostMapper {

    public Post toEntity(PostCreateRequest request, Member member) {

        return Post.builder()
                .content(request.getContent())
                .title(request.getTitle())
                .enjoyDrink(request.getEnjoyDrink())
                .likeCount(0)
                .view(0)
                .member(member)
                .build();
    }

    public Page<PostList> toPageListResponse(Page<Post> posts) {
        return posts.map(post -> PostList.builder().
                id(post.getId())
                .enjoyDrink(post.getEnjoyDrink())
                .title(post.getTitle())
                .CreateAt(post.getCreatedAt())
                .build());
    }

    public PostResponse toResponse(Post post) {
        return PostResponse.builder()
                .likeCount(post.getLikeCount())
                .view(post.getView())
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .enjoyDrink(post.getEnjoyDrink())
                .nickname(post.getMember().getNickname())
                .build();
    }

    public List<PostResponse> toListResponse(List<Post> posts) {
        return posts.stream().map(post -> PostResponse.builder()
                .likeCount(post.getLikeCount())
                .title(post.getTitle())
                .view(post.getView())
                .id(post.getId())
                .content(post.getContent())
                .enjoyDrink(post.getEnjoyDrink())
                .nickname(post.getMember().getNickname())
                .build()).collect(Collectors.toList());
    }
}
