package com.front.operator.bean.enums;

/**
 * Created by admin on 2018/2/8.
 */
public enum Search {

    SILK_ROAD("丝绸之路"),JH("京杭"),FD_AV("FD_AV"),NFD_AV("NFD_AV");
    private String value;

    private Search(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
