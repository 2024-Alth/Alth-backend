package com.alth.backend.comment.dto;

import com.alth.backend.comment.domain.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class CommentResponse {
    private Long commentId;
    private Long postId;
    private String content;
    private String writer;

    @JsonFormat(pattern = "yyyy-HH-mm HH:mm:ss")
    private LocalDateTime createAt;
    private List<CommentResponse> children = new ArrayList<>();// 대댓글에 대한 정보

    /**
     * 댓글 생성시 반환될 객체
     */

    public CommentResponse toResponse(Comment comment) {
        return CommentResponse.builder()
                .writer(comment.getWriter())
                .postId(comment.getPost().getId())
                .commentId(comment.getId())
                .content(comment.getContent())
                .createAt(comment.getCreatedAt())
                .build();
    }


    public static CommentResponse convertCommentToDto(Comment comment) {
        return comment.getIsDeleted() ?
                new CommentResponse((comment.getId()), comment.getPost().getId(), "삭제된 댓글입니다.",
                        null, comment.getCreatedAt()) :
                new CommentResponse(comment.getId(), comment.getPost().getId(), comment.getContent()
                        , comment.getWriter(), comment.getCreatedAt());
    }

    public CommentResponse(Long commentId, Long postId, String content,
                           String writer, LocalDateTime createAt) {
        this.commentId = commentId;
        this.postId = postId;
        this.content = content;
        this.writer = writer;
        this.createAt = createAt;
    }

}
