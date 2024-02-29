package com.alth.backend.comment.repository;

import com.alth.backend.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long>, CommentCustomRepository {
}
