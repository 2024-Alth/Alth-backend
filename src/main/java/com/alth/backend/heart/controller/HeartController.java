package com.alth.backend.heart.controller;

import com.alth.backend.heart.service.HeartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post/heart")
@Tag(name = "Post", description = "Post API")
public class HeartController {

    private final HeartService heartService;

    @PostMapping("/{post_id}")
    @Operation(summary = "push heart", description = "로그인한 회원이 좋아요를 누른다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<String> insert(@PathVariable("post_id") Long id) throws Exception {
        return ResponseEntity.ok().body(heartService.insert(id));
    }

    @DeleteMapping("/{post_id}")
    @Operation(summary = "delete heart", description = "로그인한 회원이 좋아요를 취소한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<String> delete(@PathVariable("post_id") Long id) throws Exception {
        return ResponseEntity.ok().body(heartService.delete(id));
    }
}
