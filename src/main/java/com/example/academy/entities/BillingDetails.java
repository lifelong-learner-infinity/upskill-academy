package com.example.academy.entities;

import com.example.academy.enums.Coupons;

public class BillingDetails implements IBillingDetails {
    private Double totalProgrammeFee;
    private Integer totalQuantity;
    private Coupons couponDiscountType;
    private Double couponDiscountAmount;
    private Double proMembershipDiscount;
    private Double proMembershipFee;
    private Double enrollmentFee;
    private Double total;

    public BillingDetails() {
        totalProgrammeFee = 0.00;
        totalQuantity = 0;
        couponDiscountType = Coupons.NONE;
        couponDiscountAmount = 0.00;
        proMembershipDiscount = 0.00;
        proMembershipFee = 0.00;
        enrollmentFee = 0.00;
        total = 0.00;
    }

    @Override
    public Double getTotalProgrammeFee() {
        return totalProgrammeFee;
    }

    @Override
    public void setTotalProgrammeFee(Double totalProgrammeFee) {
        this.totalProgrammeFee = totalProgrammeFee;
    }

    @Override
    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    @Override
    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }


    @Override
    public Coupons getCouponDiscountType() {
        return couponDiscountType;
    }

    @Override
    public void setCouponDiscountType(Coupons couponDiscountType) {
        this.couponDiscountType = couponDiscountType;
    }

    @Override
    public Double getCouponDiscountAmount() {
        return couponDiscountAmount;
    }

    @Override
    public void setCouponDiscountAmount(Double couponDiscountAmount) {
        this.couponDiscountAmount = couponDiscountAmount;
    }

    @Override
    public Double getProMembershipDiscount() {
        return proMembershipDiscount;
    }

    @Override
    public void setProMembershipDiscount(Double proMembershipDiscount) {
        this.proMembershipDiscount = proMembershipDiscount;
    }

    @Override
    public Double getProMembershipFee() {
        return proMembershipFee;
    }

    @Override
    public void setProMembershipFee(Double proMembershipFee) {
        this.proMembershipFee = proMembershipFee;
    }

    @Override
    public Double getEnrollmentFee() {
        return enrollmentFee;
    }

    @Override
    public void setEnrollmentFee(Double enrollmentFee) {
        this.enrollmentFee = enrollmentFee;
    }

    @Override
    public Double getTotal() {
        return total;
    }

    @Override
    public void setTotal(Double total) {
        this.total = total;
    }
}
