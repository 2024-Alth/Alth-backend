package com.alth.backend.alcohol.domain;

import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
public enum Types {      // any other thing
    SOJU,
    BEER,
    MAKGEOLLI,
    ETC;

//    private final int key;
//
//    Types(int key){
//        this.key = key;
//    }
//
//    public int getKey(){
//        return key;
//    }
}
