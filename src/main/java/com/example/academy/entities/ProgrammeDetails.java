package com.example.academy.entities;

public abstract class ProgrammeDetails {
    protected Double programmeCost;
    protected Double proMembershipDiscount;

    public Double getProgrammeCost() {
        return programmeCost;
    }

    public Double getProMembershipDiscount() {
        return proMembershipDiscount;
    }
}
