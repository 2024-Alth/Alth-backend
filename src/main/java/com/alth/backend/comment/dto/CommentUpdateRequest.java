package com.alth.backend.comment.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Comment update request")
public class CommentUpdateRequest {
    @Schema(description = "댓글내용", nullable = false, example = "수정된거야!")
    private String content;
}
