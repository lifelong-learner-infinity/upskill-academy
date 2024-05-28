package com.example.academy.utils;

public enum ProgramType {
    DEGREE(5000d, 0.03),
    CERTIFICATION(3000d, 0.02),
    DIPLOMA(2500d, 0.01);

    private final double cost;
    private final double discount;

    ProgramType(double cost, double discount) {
        this.cost = cost;
        this.discount = discount;
    }

    public double getCost() {
        return cost;
    }

    public double getDiscount() {
        return discount;
    }
}
