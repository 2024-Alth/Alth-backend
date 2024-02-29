package com.alth.backend.post.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Schema(description = "Post update request")
public class PostUpdateRequest {

    @NotBlank
    @Schema(description = "게시물 이름", nullable = false, example = "해장 추천좀")
    private String title;

    @NotBlank
    @Schema(description = "게시물 내용", nullable = false, example = "어제 5병 마심;;")
    private String content;
}
