package com.front.operator.bean;

import java.util.Set;

/**
 * Created by admin on 2018/2/22.
 */
public class AirLineConfig {

    private String[] departure;
    private String[] arrive;
    private Set<Airline> airline;

    public String[] getDeparture() {
        return departure;
    }

    public void setDeparture(String[] departure) {
        this.departure = departure;
    }

    public String[] getArrive() {
        return arrive;
    }

    public void setArrive(String[] arrive) {
        this.arrive = arrive;
    }

    public Set<Airline> getAirline() {
        return airline;
    }

    public void setAirline(Set<Airline> airline) {
        this.airline = airline;
    }
}
