package com.travelsupermarket.latedeals.model;

/**
 * Created by thomas.dittmer on 18/11/2016.
 */
public class PriceData {
    private String avgPrice;
    private String searchDate;

    public PriceData(String avgPrice, String searchDate) {
        this.avgPrice = avgPrice;
        this.searchDate = searchDate;
    }

    public String getAvgPrice() {
        return avgPrice;
    }

    public String searchDate() {
        return searchDate;
    }

}
