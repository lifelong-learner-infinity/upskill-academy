package com.example.academy.services;

import com.example.academy.constants.Constants;
import com.example.academy.entities.IBillingDetails;
import com.example.academy.entities.ProgramEnrollment;
import com.example.academy.entities.ProgrammeDetails;
import com.example.academy.entities.factory.ProgramFactoryProducer;
import com.example.academy.enums.Coupons;
import com.example.academy.enums.MembershipStatus;
import com.example.academy.enums.Programmes;

import java.util.Map;

public class CouponDiscountService implements ICouponDiscountService {

    private final ProgramEnrollment programEnrollment;
    private final IBillingDetails billingDetails;

    public CouponDiscountService(ProgramEnrollment programEnrollment, IBillingDetails billingDetails) {
        this.programEnrollment = programEnrollment;
        this.billingDetails = billingDetails;
    }

    @Override
    public void applyBgG1Discount() {
        Map<Programmes, Integer> programQuantity = programEnrollment.getProgramQuantity();
        MembershipStatus membershipStatus = programEnrollment.getMembershipStatus();

        Integer diplomaCount = programQuantity.get(Programmes.DIPLOMA);
        Integer certificationCount = programQuantity.get(Programmes.CERTIFICATION);

        ProgrammeDetails programmeDetails;
        double discountAmount;


        if(diplomaCount > 0) {
            programmeDetails = ProgramFactoryProducer.getProgrammeDetails(Programmes.DIPLOMA);
        } else if (certificationCount > 0) {
            programmeDetails = ProgramFactoryProducer.getProgrammeDetails(Programmes.CERTIFICATION);
        } else {
            programmeDetails = ProgramFactoryProducer.getProgrammeDetails(Programmes.DEGREE);
        }

        Double membershipDiscount = membershipStatus.equals(MembershipStatus.ADDED) ? programmeDetails.getProgrammeCost() * programmeDetails.getProMembershipDiscount() : 0;
        discountAmount = programmeDetails.getProgrammeCost() - membershipDiscount;

        billingDetails.setCouponDiscountType(Coupons.B4G1);
        billingDetails.setCouponDiscountAmount(discountAmount);
    }

    @Override
    public void applyDealG20Discount() {
        billingDetails.setCouponDiscountType(Coupons.DEAL_G20);
        billingDetails.setCouponDiscountAmount(billingDetails.getTotalProgrammeFee() * Constants.DEAL_G20_DISCOUNT);
    }

    @Override
    public void applyDealG5Discount() {
        billingDetails.setCouponDiscountType(Coupons.DEAL_G5);
        billingDetails.setCouponDiscountAmount(billingDetails.getTotalProgrammeFee() * Constants.DEAL_G5_DISCOUNT);
    }

    @Override
    public void applyNoDiscount() {
        billingDetails.setCouponDiscountType(Coupons.NONE);
        billingDetails.setCouponDiscountAmount(0.0);
    }
}
