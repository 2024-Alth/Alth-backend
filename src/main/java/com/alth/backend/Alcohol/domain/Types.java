package com.alth.backend.Alcohol.domain;

public enum Types {      // any other thing
    SOJU(1),
    BEER(2),
    MAKGEOLLI(3),
    ETC(4);

    private final int key;

    Types(int key){
        this.key = key;
    }

    public int getKey(){
        return key;
    }
}
