package com.alth.backend.comment.dto;

import com.alth.backend.comment.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReCommentResponse {
    private Long postId;
    private Long parentId;

    private Long reCommentId;
    private String content;
    private boolean isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;
    private String writer;

    public ReCommentResponse toResponse(Comment comment) {
        return ReCommentResponse.builder()
                .postId(comment.getPost().getId())
                .parentId(comment.getParent().getId())
                .reCommentId(comment.getId())
                .content(comment.getContent())
                .createAt(comment.getCreatedAt())
                .writer(comment.getWriter())
                .build();
    }
}
