package com.spartan.front.admin.dto;

import java.io.Serializable;

/**
 * Created by admin on 2018/3/1.
 */
public class FareRepertoryResponse<T>  implements Serializable {

    private T items;

    private Integer total;

    public T getItems() {
        return items;
    }

    public void setItems(T items) {
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
