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
    @JoinColumn(name = "record_id")
    private Record record;

    @Column(length = 50, nullable = false)
    private String alcoholName;

    private Double degree;

    private int price;

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
            (String alcoholName, Double degree, int price, int volume, Type alcoholType){
        this.alcoholName = alcoholName;
        this.degree = degree;
        this.price = price;
        this.volume = volume;
        this.alcoholType = alcoholType;
    }
}
