package com.alth.backend.record.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecord is a Querydsl query type for Record
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecord extends EntityPathBase<Record> {

    private static final long serialVersionUID = 2049431450L;

    public static final QRecord record = new QRecord("record");

    public final ListPath<com.alth.backend.alcohol.domain.Alcohol, com.alth.backend.alcohol.domain.QAlcohol> alcohols = this.<com.alth.backend.alcohol.domain.Alcohol, com.alth.backend.alcohol.domain.QAlcohol>createList("alcohols", com.alth.backend.alcohol.domain.Alcohol.class, com.alth.backend.alcohol.domain.QAlcohol.class, PathInits.DIRECT2);

    public final EnumPath<Feel> hangOver = createEnum("hangOver", Feel.class);

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final DatePath<java.time.LocalDate> recordDate = createDate("recordDate", java.time.LocalDate.class);

    public final NumberPath<Long> recordId = createNumber("recordId", Long.class);

    public final StringPath recordMemo = createString("recordMemo");

    public QRecord(String variable) {
        super(Record.class, forVariable(variable));
    }

    public QRecord(Path<? extends Record> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecord(PathMetadata metadata) {
        super(Record.class, metadata);
    }

}

