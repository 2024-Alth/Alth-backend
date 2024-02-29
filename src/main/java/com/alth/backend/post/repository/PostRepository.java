package com.alth.backend.post.repository;

import com.alth.backend.member.domain.EnjoyDrink;
import com.alth.backend.member.domain.Member;
import com.alth.backend.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>, PostCustomRepository {
    Page<Post> findAllByEnjoyDrink(Pageable pageable, EnjoyDrink enjoyDrink);

    Post findByMemberAndId(Member member, Long id);

    List<Post> findAllByMember(Member member);

    @Query(value = "SELECT b FROM Post b WHERE b.title LIKE %:keyword% OR b.content LIKE %:keyword% OR b.member.nickname LIKE %:keyword%")
    List<Post> findAllSearch(String keyword);
}
