package com.alth.backend.comment.controller;

import com.alth.backend.comment.dto.CommentCreateRequest;
import com.alth.backend.comment.dto.CommentResponse;
import com.alth.backend.comment.dto.CommentUpdateRequest;
import com.alth.backend.comment.dto.ReCommentResponse;
import com.alth.backend.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/post/{post_id}/comment")
    public ResponseEntity<CommentResponse> createComment(@PathVariable("post_id") Long id, @RequestBody CommentCreateRequest request) {
        return ResponseEntity.ok().body(commentService.create(id, request));
    }

    @PostMapping("/post/{post_id}/comment/{comment_id}")
    public ResponseEntity<ReCommentResponse> createComment(@PathVariable("post_id") Long postId,
                                                           @PathVariable("comment_id") Long commentId,
                                                           @RequestBody CommentCreateRequest request) {

        return ResponseEntity.ok().body(commentService.createReComment(postId, commentId, request));
    }

    @GetMapping("/post/{post_id}/comment")
    public ResponseEntity<List<CommentResponse>> getComment(@PathVariable("post_id") Long id) {
        return ResponseEntity.ok().body(commentService.getComments(id));
    }

    @PutMapping("/post/comment/{comment_id}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable("comment_id") Long id,
                                                         @RequestBody CommentUpdateRequest request) {
        return ResponseEntity.ok().body(commentService.update(id, request));
    }

    @DeleteMapping("/post/comment/{comment_id}")
    public ResponseEntity<String> delete(@PathVariable("comment_id") Long commentId) {
        return ResponseEntity.ok().body(commentService.delete(commentId));
    }
}
