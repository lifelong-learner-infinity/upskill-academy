package com.example.academy.services.invoice;

import com.example.academy.model.Program;
import com.example.academy.utils.CouponType;
import com.example.academy.utils.ProgramType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Coupon implements Discount {

    private double couponDiscount;
    private String couponApplied;

    public double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public String getCouponApplied() {
        return couponApplied;
    }

    public void setCouponApplied(String couponApplied) {
        this.couponApplied = couponApplied;
    }

    public void calculateDiscount(Program program, Invoice invoice) {
        Map<String, Integer> programs = program.getProgramMap();
        List<String> coupons = program.getCouponList();
        int totalQuantity = invoice.getTotalQuantity();
        double subTotal = invoice.getSubTotal();

        double couponDiscount = 0;
        String couponApplied = "NONE";
        boolean conditionMet = false;

        if(totalQuantity >= CouponType.B4G1.getThreshold()) {
            List<Double> programPrice = new ArrayList<>();
            for(Map.Entry<String, Integer> entry: programs.entrySet()) {
                ProgramType programType = ProgramType.valueOf(entry.getKey());
                if(program.isProMembership()) {
                    double membershipDiscount = programType.getCost() * programType.getDiscount();
                    programPrice.add(programType.getCost() - membershipDiscount);
                } else {
                    programPrice.add(programType.getCost());
                }
            }
            couponDiscount = Collections.min(programPrice);
            couponApplied = CouponType.B4G1.name();
            conditionMet = true;
        }

        if (!conditionMet && coupons.contains(CouponType.DEAL_G20.name()) && subTotal >= CouponType.DEAL_G20.getThreshold()) {
            couponDiscount = subTotal * CouponType.DEAL_G20.getDiscount();
            couponApplied = CouponType.DEAL_G20.name();
            conditionMet = true;
        }

        if(!conditionMet && coupons.contains(CouponType.DEAL_G5.name()) && totalQuantity >= 2) {
            couponDiscount = subTotal * CouponType.DEAL_G5.getDiscount();
            couponApplied = CouponType.DEAL_G5.name();
        }

        setCouponDiscount(couponDiscount);
        setCouponApplied(couponApplied);

    }
}
