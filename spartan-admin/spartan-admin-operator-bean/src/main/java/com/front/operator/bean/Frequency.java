package com.front.operator.bean;

import com.front.operator.bean.enums.TimeType;

/**
 * Created by admin on 2018/2/22.
 */
public class Frequency {

    private TimeType timeType;

    private Integer num;

    public TimeType getTimeType() {
        return timeType;
    }

    public void setTimeType(TimeType timeType) {
        this.timeType = timeType;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
