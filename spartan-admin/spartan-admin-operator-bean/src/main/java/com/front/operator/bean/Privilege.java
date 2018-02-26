package com.front.operator.bean;

import com.front.operator.bean.enums.Fare;
import com.front.operator.bean.enums.Search;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by admin on 2018/2/8.
 */
public class Privilege {

    private Set<Search> search;

    private Set<Fare> fare;

    public Set<Search> getSearch() {
        if(this.search == null) {
            return new HashSet<>();
        }
        return search;
    }

    public void setSearch(Set<Search> search) {
        this.search = search;
    }

    public Set<Fare> getFare() {
        if(this.fare == null) {
            return new HashSet<>();
        }
        return fare;
    }

    public void setFare(Set<Fare> fare) {
        this.fare = fare;
    }
}
