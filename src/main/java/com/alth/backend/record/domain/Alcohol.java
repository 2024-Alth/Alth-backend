package com.alth.backend.record.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long alcoholId;

    @Column(length = 50, nullable = false)
    private String alcoholName;

    private Double degree;

    private int price;

    private int volume;

    @Enumerated(EnumType.STRING)
    private Type alcoholType;

    @OneToMany(mappedBy = "alcohol")
    private List<Record> records = new ArrayList<>();


    public enum Type {
        SOJU,
        BEER,
        MAKGEOLLI,
        ETC // any other thing
    }
}
