package com.example.academy.utils;

public enum CouponType {
    B4G1(4, 0),
    DEAL_G20(10000d, 0.2),
    DEAL_G5(2, 0.05);

    private final double threshold;
    private final double discount;

    CouponType(double threshold, double discount) {
        this.threshold = threshold;
        this.discount = discount;
    }

    public double getThreshold() {
        return threshold;
    }

    public double getDiscount() {
        return discount;
    }
}
