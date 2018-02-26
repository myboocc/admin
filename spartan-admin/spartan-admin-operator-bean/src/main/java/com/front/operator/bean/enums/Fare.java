package com.front.operator.bean.enums;

/**
 * Created by admin on 2018/2/8.
 */
public enum Fare {

    FD("FD"),NFD("NFD");
    private String value;

    private Fare(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
