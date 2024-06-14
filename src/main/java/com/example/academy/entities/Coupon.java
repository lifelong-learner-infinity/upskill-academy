package com.example.academy.entities;

public abstract class Coupon {
    protected String code;
    protected Double discount;
    protected Integer minimumPrograms;
    protected Integer minPurchaseAmount;

    public String getCode() {
        return code;
    }

    public Double getDiscount() {
        return discount;
    }

    public Integer getMinimumPrograms() {
        return minimumPrograms;
    }

    public Integer getMinPurchaseAmount() {
        return minPurchaseAmount;
    }
}
