package com.alth.backend.post.domain;

import com.alth.backend.global.BaseTimeEntity;
import com.alth.backend.member.domain.EnjoyDrink;
import com.alth.backend.member.domain.Member;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

@Entity
@Builder
@Getter
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "is_deleted = false")
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String title;

    private String content;

    private int view;

    private Integer likeCount;

    @Enumerated(value = EnumType.STRING)
    private EnjoyDrink enjoyDrink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updateView() {
        this.view++;
    }
}
