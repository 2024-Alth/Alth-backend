package com.alth.backend.record.domain;


import com.alth.backend.Alcohol.domain.Alcohol;
import com.alth.backend.global.BaseTimeEntity;
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
@SQLDelete(sql = "UPDATE record SET is_deleted = true WHERE record_id =  ?")
@Where(clause = "is_deleted = false")
@ToString
public class Record extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long recordId;

    private int totalCnt;

    @Enumerated(EnumType.STRING)
    private Feel hangOver;

    @Column(length = 500, nullable = false)
    private String recordMemo;

    @Builder.Default
    private boolean isDeleted = Boolean.FALSE; // default - FALSE



    @OneToMany(mappedBy = "record", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alcohol> alcohols = new ArrayList<>();


    public void delete() {
        this.isDeleted = true;
        this.getAlcohols().forEach(alcohol -> alcohol.delete());
    }

    public void updateRecord(int totalCnt, Feel hangOver, String recordMemo){
        this.totalCnt = totalCnt;
        this.hangOver = hangOver;
        this.recordMemo = recordMemo;
    }

    @Builder
    public Record(int totalCnt, Feel hangOver, String recordMemo) {
        this.totalCnt = totalCnt;
        this.hangOver = hangOver;
        this.recordMemo = recordMemo;
    }

    public void addAlcohol(Alcohol alcohol){
        this.alcohols.add(alcohol);
    }
}
