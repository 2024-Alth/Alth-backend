package com.alth.backend.record.domain;

public enum Feel {     //sat as 4 type(changeable)
    ALIVE(0),
    LITTLE(1),
    FULLY(2),
    DEATH(3);

    private final int key;

    Feel(int key){
        this.key = key;
    }

    public int getKey(){
        return key;
    }
}
