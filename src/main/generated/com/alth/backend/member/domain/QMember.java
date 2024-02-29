package com.alth.backend.member.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -165355412L;

    public static final QMember member = new QMember("member1");

    public final com.alth.backend.global.QBaseTimeEntity _super = new com.alth.backend.global.QBaseTimeEntity(this);

    public final BooleanPath activated = createBoolean("activated");

    public final SetPath<Authority, QAuthority> authorities = this.<Authority, QAuthority>createSet("authorities", Authority.class, QAuthority.class, PathInits.DIRECT2);

    public final NumberPath<Integer> birth = createNumber("birth", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<EnjoyDrink> enjoyDrink = createEnum("enjoyDrink", EnjoyDrink.class);

    public final StringPath favorLiquor = createString("favorLiquor");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final ListPath<com.alth.backend.post.domain.Post, com.alth.backend.post.domain.QPost> posts = this.<com.alth.backend.post.domain.Post, com.alth.backend.post.domain.QPost>createList("posts", com.alth.backend.post.domain.Post.class, com.alth.backend.post.domain.QPost.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

