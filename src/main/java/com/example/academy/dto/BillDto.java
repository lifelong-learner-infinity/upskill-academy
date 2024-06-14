package com.example.academy.dto;

import com.example.academy.enums.Coupons;

public class BillDto {
    private final Double totalProgrammeFee;
    private final Coupons couponDiscountType;
    private final Double couponDiscountAmount;
    private final Double proMembershipDiscount;
    private final Double proMembershipFee;
    private final Double enrollmentFee;
    private final Double total;

    public BillDto(Double totalProgrammeFee, Coupons couponDiscountType, Double couponDiscountAmount, Double proMembershipDiscount, Double proMembershipFee, Double enrollmentFee, Double total) {
        this.totalProgrammeFee = totalProgrammeFee;
        this.couponDiscountType = couponDiscountType;
        this.couponDiscountAmount = couponDiscountAmount;
        this.proMembershipDiscount = proMembershipDiscount;
        this.proMembershipFee = proMembershipFee;
        this.enrollmentFee = enrollmentFee;
        this.total = total;
    }

    public Double getTotalProgrammeFee() {
        return totalProgrammeFee;
    }

    public Coupons getCouponDiscountType() {
        return couponDiscountType;
    }

    public Double getCouponDiscountAmount() {
        return couponDiscountAmount;
    }

    public Double getProMembershipDiscount() {
        return proMembershipDiscount;
    }

    public Double getProMembershipFee() {
        return proMembershipFee;
    }

    public Double getEnrollmentFee() {
        return enrollmentFee;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "SUB_TOTAL " + String.format("%.2f", totalProgrammeFee) +
                "\nCOUPON_DISCOUNT " + couponDiscountType + " " + String.format("%.2f", couponDiscountAmount) +
                "\nTOTAL_PRO_DISCOUNT " + String.format("%.2f",proMembershipDiscount) +
                "\nPRO_MEMBERSHIP_FEE " + String.format("%.2f",proMembershipFee) +
                "\nENROLLMENT_FEE " + String.format("%.2f",enrollmentFee) +
                "\nTOTAL " + String.format("%.2f",total);
    }
}
