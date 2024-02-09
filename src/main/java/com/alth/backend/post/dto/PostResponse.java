package com.alth.backend.post.dto;


import com.alth.backend.member.domain.EnjoyDrink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private int view;
    private Integer likeCount;
    private EnjoyDrink enjoyDrink;
    private String nickname;
}
