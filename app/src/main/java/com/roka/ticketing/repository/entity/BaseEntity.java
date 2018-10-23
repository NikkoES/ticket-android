package com.roka.ticketing.repository.entity;

import java.io.Serializable;

public class BaseEntity implements Serializable{
    int numOrder;

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }
}
