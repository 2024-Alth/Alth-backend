package com.alth.backend.heart;

import com.alth.backend.heart.domain.Heart;
import com.alth.backend.member.domain.Member;
import com.alth.backend.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {
    Optional<Heart> findByMemberAndPost(Member member, Post post);
}
