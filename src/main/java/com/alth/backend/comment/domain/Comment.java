package com.alth.backend.comment.domain;

import com.alth.backend.global.BaseTimeEntity;
import com.alth.backend.member.domain.Member;
import com.alth.backend.post.domain.Post;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    private String writer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private final List<Comment> children = new ArrayList<>();

    @ColumnDefault("FALSE")
    @Column(nullable = false)
    private Boolean isDeleted;

    public void update(String content) {
        this.content = content;
    }

    public void confirmParent(Comment comment) {
        this.parent = comment;
    }

    public void confirmPost(Post post) {
        this.post = post;
    }

    public void confirmMember(Member member) {
        this.member = member;
    }

    public void confirmWriter(Member member) {
        this.writer = member.getNickname();
    }

    public void delete() {
        this.isDeleted = true;
    }
}
