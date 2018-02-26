package com.front.operator.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by admin on 2018/2/8.
 */
@Document(collection = "airline")
public class FareSource {
    @Id
    private String id;
    private String openId;

    private String source;

    private AirLineConfig airLineConfig;

    private BaseDataConfig baseDataConfig;

    private Date departStartTime;

    private Date departEndTime;

    private Frequency frequency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public AirLineConfig getAirLineConfig() {
        return airLineConfig;
    }

    public void setAirLineConfig(AirLineConfig airLineConfig) {
        this.airLineConfig = airLineConfig;
    }

    public BaseDataConfig getBaseDataConfig() {
        return baseDataConfig;
    }

    public void setBaseDataConfig(BaseDataConfig baseDataConfig) {
        this.baseDataConfig = baseDataConfig;
    }

    public Date getDepartStartTime() {
        return departStartTime;
    }

    public void setDepartStartTime(Date departStartTime) {
        this.departStartTime = departStartTime;
    }

    public Date getDepartEndTime() {
        return departEndTime;
    }

    public void setDepartEndTime(Date departEndTime) {
        this.departEndTime = departEndTime;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
}
