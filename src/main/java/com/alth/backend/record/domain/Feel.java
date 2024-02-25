package com.alth.backend.record.domain;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public enum Feel {     //sat as 4 type(changeable)
    ALIVE,
    LITTLE,
    FULLY,
    DEATH;

//    private final int key;
//
//    Feel(int key){
//        this.key = key;
//    }
//
//    public int getKey(){
//        return key;
//    }
}
