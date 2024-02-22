package com.alth.backend.comment.dto;

import com.alth.backend.comment.domain.Comment;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Schema(description = "Comment create request")
public class CommentCreateRequest {

    @NotBlank
    @Schema(description = "댓글내용", nullable = false, example = "안녕 난 짱이야")
    private String content;

    public Comment toEntity(CommentCreateRequest request) {
        return Comment.builder()
                .content(request.getContent())
                .isDeleted(false)
                .build();
    }
}
