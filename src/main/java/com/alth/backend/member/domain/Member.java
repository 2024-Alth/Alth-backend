package com.alth.backend.member.domain;

import com.alth.backend.global.BaseTimeEntity;
import com.alth.backend.post.domain.Post;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE member SET is_deleted = true WHERE user_id =?")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    private String name;

    @Column(unique = true)
    private String nickname;

    private int birth;

    private boolean activated;

    @Enumerated(value = EnumType.STRING)
    private EnjoyDrink enjoyDrink;

    private String favorLiquor;

    private Boolean isDeleted;

    @OneToMany(mappedBy = "member")
    private final List<Post> posts = new ArrayList<>();

    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    @ManyToMany
    private Set<Authority> authorities;

    public void update(String nickname, int birth, String name, EnjoyDrink enjoyDrink, String favorLiquor) {
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.enjoyDrink = enjoyDrink;
        this.favorLiquor = favorLiquor;
    }
}
