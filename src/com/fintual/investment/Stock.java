package com.fintual.investment;

import java.time.LocalDate;

public class Stock {
    private String id;

    public Stock(String id){
        this.id = id;
    }

    public double getPrice(LocalDate date) {
        return Math.random()*100;
    }

    public String getId() {
        return id;
    }
}
