package com.alth.backend.post.repository;

import com.alth.backend.post.domain.Post;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.alth.backend.post.domain.QPost.post;

@RequiredArgsConstructor
@Repository
public class PostRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public void addLikeCount(Post selectedPost) {
        queryFactory.update(post)
                .set(post.likeCount, post.likeCount.add(1))
                .where(post.eq(selectedPost))
                .execute();
    }

    @Override
    public void subLikeCount(Post selectedPost) {
        queryFactory.update(post)
                .set(post.likeCount, post.likeCount.subtract(1))
                .where(post.eq(selectedPost))
                .execute();
    }
}
