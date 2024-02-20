package com.alth.backend.record.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@SQLDelete(sql = "UPDATE alcohol SET is_deleted = true WHERE alcohol_id =  ?")
@Where(clause = "is_deleted = false")
@ToString(exclude = "record")
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long alcoholId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id", nullable = true)
    private Record record;

    @Column(length = 50, nullable = false)
    private String alcoholName;

    private Double degree;

    private int price;

    private int alCnt;

    private int volume;

    @Enumerated(EnumType.STRING)
    private Type alcoholType;

    @Builder.Default
    private boolean isDeleted = Boolean.FALSE; // default - FALSE

    public enum Type {
        SOJU,
        BEER,
        MAKGEOLLI,
        ETC // any other thing
    }

    public void delete() {
        this.isDeleted = true;
    }

    public void updateAlcohol
            (String alcoholName, Double degree, int price, int alCnt, int volume, Type alcoholType, Record record){
        this.alcoholName = alcoholName;
        this.degree = degree;
        this.price = price;
        this.alCnt = alCnt;
        this.volume = volume;
        this.alcoholType = alcoholType;
        this.record = record; // add - 0210
    }

    public Alcohol createAlcohol(String alcoholName, Double degree, int price, int alCnt, int volume, Type alcoholType, Record record){
        return Alcohol.builder()
                .alcoholName(alcoholName)
                .degree(degree)
                .price(price)
                .alCnt(alCnt)
                .volume(volume)
                .alcoholType(alcoholType)
                .record(record)
                .build();
    }

    @Builder
    public Alcohol(Record record, String alcoholName, Double degree, int price, int alCnt, int volume, Type alcoholType) {
        this.record = record;
        this.alcoholName = alcoholName;
        this.degree = degree;
        this.price = price;
        this.alCnt = alCnt;
        this.volume = volume;
        this.alcoholType = alcoholType;
    }
}
