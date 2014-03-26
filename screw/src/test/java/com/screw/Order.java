package com.screw;

import java.math.BigDecimal;

public class Order {

    private int id;
    private BigDecimal price;
    private String where;
//    private int[] tags;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

//    public int[] getTags() {
//        return tags;
//    }
//
//    public void setTags(int[] tags) {
//        this.tags = tags;
//    }

}
