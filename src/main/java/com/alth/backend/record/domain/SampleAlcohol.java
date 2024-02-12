package com.alth.backend.record.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SampleAlcohol {

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

    private int volume;

    @Enumerated(EnumType.STRING)
    private Type alcoholType;


    public enum Type {
        SOJU,
        BEER,
        MAKGEOLLI,
        ETC // any other thing
    }
}
