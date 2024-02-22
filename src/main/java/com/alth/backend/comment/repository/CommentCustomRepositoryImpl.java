package com.alth.backend.comment.repository;

import com.alth.backend.comment.domain.Comment;
import com.alth.backend.comment.dto.CommentResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.alth.backend.comment.domain.QComment.comment;


@Repository
@RequiredArgsConstructor
public class CommentCustomRepositoryImpl implements CommentCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<CommentResponse> findByPostId(Long id) {

        List<Comment> comments = queryFactory.selectFrom(comment)
                .leftJoin(comment.parent).fetchJoin()
                .where(comment.post.id.eq(id))
                .orderBy(comment.parent.id.asc().nullsFirst(),
                        comment.createdAt.asc())
                .fetch();

        List<CommentResponse> commentResponseList = new ArrayList<>();
        Map<Long, CommentResponse> commentResponseMap = new HashMap<>();

        comments.forEach(c ->{
                    CommentResponse commentResponse = CommentResponse.convertCommentToDto(c);
                    commentResponseMap.put(commentResponse.getCommentId(), commentResponse);
                    if(c.getParent() != null) commentResponseMap.get(c.getParent().getId()).getChildren()
                            .add(commentResponse);
                    else commentResponseList.add(commentResponse);
                });
        return commentResponseList;
    }

    @Override
    public Optional<Comment> findCommentByIdWithParent(Long id) {

        Comment selectedComment = queryFactory.select(comment)
                .from(comment)
                .leftJoin(comment.parent).fetchJoin()
                .where(comment.id.eq(id))
                .fetchOne();

        return Optional.ofNullable(selectedComment);
    }
}
