package com.alth.backend.alcohol.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlcohol is a Querydsl query type for Alcohol
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlcohol extends EntityPathBase<Alcohol> {

    private static final long serialVersionUID = -1685952192L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAlcohol alcohol = new QAlcohol("alcohol");

    public final NumberPath<Integer> alCnt = createNumber("alCnt", Integer.class);

    public final NumberPath<Long> alcoholId = createNumber("alcoholId", Long.class);

    public final StringPath alcoholName = createString("alcoholName");

    public final EnumPath<Types> alcoholType = createEnum("alcoholType", Types.class);

    public final NumberPath<Double> degree = createNumber("degree", Double.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final com.alth.backend.record.domain.QRecord record;

    public final NumberPath<Integer> volume = createNumber("volume", Integer.class);

    public QAlcohol(String variable) {
        this(Alcohol.class, forVariable(variable), INITS);
    }

    public QAlcohol(Path<? extends Alcohol> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAlcohol(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAlcohol(PathMetadata metadata, PathInits inits) {
        this(Alcohol.class, metadata, inits);
    }

    public QAlcohol(Class<? extends Alcohol> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.record = inits.isInitialized("record") ? new com.alth.backend.record.domain.QRecord(forProperty("record")) : null;
    }

}

