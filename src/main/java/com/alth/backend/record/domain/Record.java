package com.alth.backend.record.domain;


import com.alth.backend.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

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

    private boolean isDeleted = Boolean.FALSE; // default - FALSE

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alcohol_id")
    private Alcohol alcohol;


    public enum Feels {
        ALIVE,
        LITTLE,
        FULLY,
        DEATH //sat as 4 type(changeable)
    }

    public void delete() {
        this.isDeleted = true;
    }

    public void updateRecord(int alCnt, Feels hangOver, String recordMemo){
        this.alCnt = alCnt;
        this.hangOver = hangOver;
        this.recordMemo = recordMemo;
    }
}
