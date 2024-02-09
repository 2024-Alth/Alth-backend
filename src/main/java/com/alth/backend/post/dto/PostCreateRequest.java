package com.alth.backend.post.dto;

import com.alth.backend.member.domain.EnjoyDrink;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Post create request")
public class PostCreateRequest {

    @NotBlank
    @Schema(description = "게시물 이름", nullable = false, example = "술 마시고싶다")
    private String title;

    @NotBlank
    @Schema(description = "게시물 내용", nullable = false, example = "술 안마신지 7일됨;")
    private String content;

    @NotNull
    @Schema(description = "게시물 내용", nullable = false, example = "DRINK")
    private EnjoyDrink enjoyDrink;
}
