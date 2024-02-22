package com.alth.backend.comment.repository;

import com.alth.backend.comment.domain.Comment;
import com.alth.backend.comment.dto.CommentResponse;

import java.util.List;
import java.util.Optional;

public interface CommentCustomRepository {

    List<CommentResponse> findByPostId(Long id);

    Optional<Comment> findCommentByIdWithParent(Long id);
}
