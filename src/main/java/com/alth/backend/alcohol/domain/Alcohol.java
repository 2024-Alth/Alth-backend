package com.alth.backend.alcohol.domain;

import com.alth.backend.record.domain.Record;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@SQLDelete(sql = "UPDATE alcohol SET is_deleted = true WHERE alcohol_id =  ?")
@Where(clause = "is_deleted = false")
@ToString(exclude = "record")
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long alcoholId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "record_id")
    private Record record;

    @Column(length = 50, nullable = false)
    private String alcoholName;

    private Double degree;

    private int price;

    private int alCnt;

    private int volume;

    @Enumerated(EnumType.STRING)
    private Types alcoholType;

    @Builder.Default
    private boolean isDeleted = Boolean.FALSE; // default - FALSE

    public void delete() {
        this.isDeleted = true;
    }

    public void updateAlcohol
            (String alcoholName, Double degree, int price, int alCnt, int volume, Types alcoholType){
        this.alcoholName = alcoholName;
        this.degree = degree;
        this.price = price;
        this.alCnt = alCnt;
        this.volume = volume;
        this.alcoholType = alcoholType;
    }

    @Builder
    public Alcohol(Record record, String alcoholName, Double degree, int price, int alCnt, int volume, Types alcoholType) {
        this.record = record;
        this.alcoholName = alcoholName;
        this.degree = degree;
        this.price = price;
        this.alCnt = alCnt;
        this.volume = volume;
        this.alcoholType = alcoholType;
    }
}
