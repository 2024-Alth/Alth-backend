package com.alth.backend.record.domain;


import com.alth.backend.global.BaseTimeEntity;
import jakarta.annotation.Nullable;
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
@SQLDelete(sql = "UPDATE record SET is_deleted = true WHERE record_id =  ?")
@Where(clause = "is_deleted = false")
@ToString
public class Record extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long recordId;

    private int alCnt;

    @Enumerated(EnumType.STRING)
    private Feels hangOver;

    @Column(length = 500, nullable = false)
    private String recordMemo;

    @Builder.Default
    private boolean isDeleted = Boolean.FALSE; // default - FALSE


    @Builder.Default
    @OneToMany(mappedBy = "record", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Alcohol> alcohols = new ArrayList<>();


    @Builder.Default
    @OneToMany(mappedBy = "record", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<SampleAlcohol> sampleAlcohols = new ArrayList<>();

    public enum Feels {
        ALIVE,
        LITTLE,
        FULLY,
        DEATH //sat as 4 type(changeable)
    }

    public void delete() {
        this.isDeleted = true;
        this.getAlcohols().forEach(alcohol -> alcohol.delete());
    }

    public void updateRecord(int alCnt, Feels hangOver, String recordMemo){
        this.alCnt = alCnt;
        this.hangOver = hangOver;
        this.recordMemo = recordMemo;
    }

    public void createRecord(int alCnt, Feels hangOver, String recordMemo){
        this.alCnt = alCnt;
        this.hangOver = hangOver;
        this.recordMemo = recordMemo;
    }
}
