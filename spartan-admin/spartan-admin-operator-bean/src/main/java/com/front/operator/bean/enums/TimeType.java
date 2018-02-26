package com.front.operator.bean.enums;

/**
 * Created by admin on 2018/2/22.
 */
public enum TimeType {

    MINUTES("分钟"), HOURS("小时"), DAY("天");

    private String value;

    private TimeType(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

}
