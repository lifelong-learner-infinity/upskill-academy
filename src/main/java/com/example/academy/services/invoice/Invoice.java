package com.example.academy.services.invoice;

import com.example.academy.utils.ProgramType;

import java.util.Map;

public class Invoice {

    private static final String PRINT_SUB_TOTAL = "SUB_TOTAL %.2f\n";
    private static final String PRINT_COUPON_DISCOUNT = "COUPON_DISCOUNT %s %.2f\n";
    private static final String PRINT_TOTAL_PRO_DISCOUNT = "TOTAL_PRO_DISCOUNT %.2f\n";
    private static final String PRINT_PRO_MEMBERSHIP_FEE = "PRO_MEMBERSHIP_FEE %.2f\n";
    private static final String PRINT_ENROLLMENT_FEE = "ENROLLMENT_FEE %.2f\n";
    private static final String PRINT_TOTAL = "TOTAL %.2f";

    private double subTotal;
    private int totalQuantity;

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void calculateSubTotal(Map<String, Integer> programs) {
        double subTotal = 0;
        int totalQuantity = 0;

        for(Map.Entry<String, Integer> entry: programs.entrySet()) {
            ProgramType programType = ProgramType.valueOf(entry.getKey());
            subTotal += programType.getCost() * entry.getValue();
            totalQuantity += entry.getValue();
        }

        setSubTotal(subTotal);
        setTotalQuantity(totalQuantity);
    }

    public void printInvoice(Invoice invoice, Coupon coupon, Membership membership, double enrollmentFees) {
        double total = invoice.getSubTotal() - coupon.getCouponDiscount() + enrollmentFees;
        double proMembershipFees = membership.getProMembershipDiscount() > 0 ? Membership.PRO_MEMBERSHIP_FEES : 0;

        System.out.printf(PRINT_SUB_TOTAL, subTotal);
        System.out.printf(PRINT_COUPON_DISCOUNT, coupon.getCouponApplied(), coupon.getCouponDiscount());
        System.out.printf(PRINT_TOTAL_PRO_DISCOUNT, membership.getProMembershipDiscount());
        System.out.printf(PRINT_PRO_MEMBERSHIP_FEE, proMembershipFees);
        System.out.printf(PRINT_ENROLLMENT_FEE, enrollmentFees);
        System.out.printf(PRINT_TOTAL, total);
    }
}
