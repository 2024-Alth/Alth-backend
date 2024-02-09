package com.alth.backend.post.dto;

import com.alth.backend.member.domain.EnjoyDrink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostList {
    private Long id;
    private String title;
    private EnjoyDrink enjoyDrink;
    private LocalDateTime CreateAt;
}
