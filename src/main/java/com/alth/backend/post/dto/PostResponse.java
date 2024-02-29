package com.alth.backend.post.dto;


import com.alth.backend.member.domain.EnjoyDrink;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;
}
