package com.alth.backend.post.controller;

import com.alth.backend.member.domain.EnjoyDrink;
import com.alth.backend.post.dto.*;
import com.alth.backend.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Post", description = "Post API")
public class PostController {

    private final PostService postService;

    @PostMapping("/post")
    @Operation(summary = "create Post", description = "게시물을 생성한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<Long> createPost(@Valid @RequestBody PostCreateRequest request) {
        return ResponseEntity.ok().body(postService.create(request));
    }

    @GetMapping("/postList/{enjoy_drink}")
    @Operation(summary = "get PostList By EnjoyDrink", description = "게시물을 금주, 음주 카테고리별로 전체 조회한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<PostListResponse> getPostList(@PathVariable("enjoy_drink") EnjoyDrink enjoyDrink,
                                                  @PageableDefault(page = 0, size = 10, sort = "id",
                                                                direction = Sort.Direction.DESC) Pageable pageable) {

        Page<PostList> postList = postService.getPostList(enjoyDrink, pageable);
        PostListResponse res = PostListResponse.builder().date(postList).build();

        return ResponseEntity.ok(res);
    }

    @PutMapping("/post/{post_id}")
    @Operation(summary = "update post", description = "게시물을 수정한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<String> updatePost(@PathVariable("post_id") Long id
            , @Valid @RequestBody PostUpdateRequest request) {

        return ResponseEntity.ok().body(postService.update(request, id));
    }

    @GetMapping("/post/{post_id}")
    @Operation(summary = "get postInfo", description = "게시물을 조회한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<PostResponse> getPostInfo(@PathVariable("post_id") Long id) {

        return ResponseEntity.ok(postService.getPost(id));
    }

    @GetMapping("/post/search/{keyword}")
    @Operation(summary = "get postInfo", description = "게시물을 조회한다.")
    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "성공"))
    public ResponseEntity<List<PostResponse>> getPostByKeyword(@PathVariable("keyword") String keyword) {
        return ResponseEntity.ok(postService.getPostSearch(keyword));
    }

}
