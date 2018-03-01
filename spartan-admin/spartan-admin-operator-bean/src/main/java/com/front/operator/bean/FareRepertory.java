package com.front.operator.bean;

/**
 * Created by admin on 2018/3/1.
 */
public class FareRepertory {

    private String id;

    private String departCode; //出发机场三字码
    private String arriveCode; //到达机场三字码
    private String airline;    // 航司
    private String cabin;      // 舱位
    private String price;      // 价格
    private String fareSource; // 运价源
    private String crawlTime;  // 爬取时间
    private String fareValidStartTime; // 运价有效起始时间
    private String fareValidEndTime;// 运价有效截止时间
    private String aheadIssueDay;   // 提前开票天数

    public FareRepertory() {
    }

    public FareRepertory(String departCode, String arriveCode, String airline, String cabin, String price, String fareSource, String crawlTime, String fareValidStartTime, String fareValidEndTime, String aheadIssueDay) {
        this.departCode = departCode;
        this.arriveCode = arriveCode;
        this.airline = airline;
        this.cabin = cabin;
        this.price = price;
        this.fareSource = fareSource;
        this.crawlTime = crawlTime;
        this.fareValidStartTime = fareValidStartTime;
        this.fareValidEndTime = fareValidEndTime;
        this.aheadIssueDay = aheadIssueDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFareSource() {
        return fareSource;
    }

    public void setFareSource(String fareSource) {
        this.fareSource = fareSource;
    }

    public String getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(String crawlTime) {
        this.crawlTime = crawlTime;
    }

    public String getFareValidStartTime() {
        return fareValidStartTime;
    }

    public void setFareValidStartTime(String fareValidStartTime) {
        this.fareValidStartTime = fareValidStartTime;
    }

    public String getFareValidEndTime() {
        return fareValidEndTime;
    }

    public void setFareValidEndTime(String fareValidEndTime) {
        this.fareValidEndTime = fareValidEndTime;
    }

    public String getAheadIssueDay() {
        return aheadIssueDay;
    }

    public void setAheadIssueDay(String aheadIssueDay) {
        this.aheadIssueDay = aheadIssueDay;
    }
}
