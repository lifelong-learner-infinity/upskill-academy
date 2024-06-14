package com.example.academy.services;

import com.example.academy.constants.Constants;
import com.example.academy.dto.BillDto;
import com.example.academy.entities.IBillingDetails;
import com.example.academy.entities.ProgramEnrollment;
import com.example.academy.enums.Coupons;
import com.example.academy.enums.MembershipStatus;

public class BillService implements IBillService {

    private final ProgramEnrollment programEnrollment;
    private final IBillingDetails billingDetails;

    private final ICartService cartService;
    private final ICouponDiscountService couponDiscountService;

    public BillService(ProgramEnrollment programEnrollment, IBillingDetails billingDetails, ICartService cartService, ICouponDiscountService couponDiscountService) {
        this.programEnrollment = programEnrollment;
        this.billingDetails = billingDetails;
        this.cartService = cartService;
        this.couponDiscountService = couponDiscountService;
    }

    private void calculateTotalCartItemCost() {
        cartService.calculateTotalCost();
        if(programEnrollment.getMembershipStatus().equals(MembershipStatus.ADDED)) {
            cartService.calculateTotalProMembershipDiscount();;
        }
    }

    private void calculateCouponDiscount() {
        Integer totalPrograms = billingDetails.getTotalQuantity();
        if(totalPrograms >= 4) {
            couponDiscountService.applyBgG1Discount();
        } else if (programEnrollment.getCouponsList().contains(Coupons.DEAL_G20) && billingDetails.getTotalProgrammeFee() >= Constants.PROGRAMME_COST_FOR_G20_DISCOUNT) {
            couponDiscountService.applyDealG20Discount();
        } else if (programEnrollment.getCouponsList().contains(Coupons.DEAL_G5) && totalPrograms >= Constants.PROGRAMME_COUNT_FOR_G5_DISCOUNT) {
            couponDiscountService.applyDealG5Discount();
        } else {
            couponDiscountService.applyNoDiscount();
        }
    }

    private void checkEnrollmentEligibility() {
        Double totalAmount = billingDetails.getTotalProgrammeFee();
        if(totalAmount < Constants.PROGRAMME_COST_TRESHOLD_FOR_ENROLLMENT_FEE) {
            billingDetails.setEnrollmentFee(Constants.ENROLLMENT_FEE);
        }
    }

    private void calculateTotal() {
        Double total = billingDetails.getTotalProgrammeFee() -
                billingDetails.getCouponDiscountAmount() +
                billingDetails.getEnrollmentFee();
        billingDetails.setTotal(total);
    }

    @Override
    public BillDto calculateBill() {
        calculateTotalCartItemCost();
        calculateCouponDiscount();
        checkEnrollmentEligibility();
        calculateTotal();

        return new BillDto(
                billingDetails.getTotalProgrammeFee(),
                billingDetails.getCouponDiscountType(),
                billingDetails.getCouponDiscountAmount(),
                billingDetails.getProMembershipDiscount(),
                billingDetails.getProMembershipFee(),
                billingDetails.getEnrollmentFee(),
                billingDetails.getTotal()
        );
    }
}
