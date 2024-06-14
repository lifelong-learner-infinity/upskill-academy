package com.example.academy.entities;

import com.example.academy.enums.Coupons;

public interface IBillingDetails {
    Double getTotalProgrammeFee();
    void setTotalProgrammeFee(Double totalProgrammeFee);
    Integer getTotalQuantity();
    void setTotalQuantity(int totalQuantity);
    Coupons getCouponDiscountType();
    void setCouponDiscountType(Coupons couponDiscountType);
    Double getCouponDiscountAmount();
    void setCouponDiscountAmount(Double couponDiscountAmount);
    Double getProMembershipDiscount();
    void setProMembershipDiscount(Double proMembershipDiscount);
    Double getProMembershipFee();
    void setProMembershipFee(Double proMembershipFee);
    Double getEnrollmentFee();
    void setEnrollmentFee(Double enrollmentFee);
    Double getTotal();
    void setTotal(Double total);
}
