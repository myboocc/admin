package com.spartan.front.admin.dto;

import java.io.Serializable;

/**
 * Created by admin on 2018/3/1.
 */
public class FareRepertoryQuery implements Serializable {

    private String departCode; //出发机场三字码
    private String arriveCode; //到达机场三字码
    private String airline;    // 航司
    private String cabin;      // 舱位
    private String fareSource; // 运价源

    private Integer page;
    private Integer limit;
    private Integer total;

    public String getDepartCode() {
        return departCode;
    }

    public void setDepartCode(String departCode) {
        this.departCode = departCode;
    }

    public String getArriveCode() {
        return arriveCode;
    }

    public void setArriveCode(String arriveCode) {
        this.arriveCode = arriveCode;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getFareSource() {
        return fareSource;
    }

    public void setFareSource(String fareSource) {
        this.fareSource = fareSource;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
