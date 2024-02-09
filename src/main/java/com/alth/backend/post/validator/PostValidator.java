package com.alth.backend.post.validator;

import com.alth.backend.post.domain.Post;
import org.springframework.stereotype.Component;

@Component
public class PostValidator {
    public void postExistValid(Post post) {
        if (post == null) {
            throw new RuntimeException("게시물 조회 실패");
        }
    }
}
