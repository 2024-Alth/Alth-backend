package com.alth.backend.member.domain;

public enum EnjoyDrink {

    DRINK("음주"),
    NONDRINK("금주");

    private final String korean;

    EnjoyDrink(String korean) {
        this.korean = korean;
    }
    public String getKorean() {
        return korean;
    }
}
