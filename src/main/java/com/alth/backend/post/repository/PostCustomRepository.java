package com.alth.backend.post.repository;

import com.alth.backend.post.domain.Post;

public interface PostCustomRepository {

    void addLikeCount(Post post);

    void subLikeCount(Post post);
}
