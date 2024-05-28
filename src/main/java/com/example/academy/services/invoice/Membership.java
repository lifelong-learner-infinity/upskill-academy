package com.example.academy.services.invoice;

import com.example.academy.model.Program;
import com.example.academy.utils.ProgramType;

import java.util.Map;

public class Membership implements Discount {

    private double proMembershipDiscount;

    public double getProMembershipDiscount() {
        return proMembershipDiscount;
    }

    public void setProMembershipDiscount(double proMembershipDiscount) {
        this.proMembershipDiscount = proMembershipDiscount;
    }

    public static final double PRO_MEMBERSHIP_FEES = 200d;

    public void calculateDiscount(Program program, Invoice invoice) {
        Map<String, Integer> programs = program.getProgramMap();

        double discount = 0;
        if(program.isProMembership()) {
            for (Map.Entry<String, Integer> entry : programs.entrySet()) {
                ProgramType programType = ProgramType.valueOf(entry.getKey());
                discount += programType.getCost() * programs.get(programType.name()) * programType.getDiscount();
            }
            double subTotal = invoice.getSubTotal() + PRO_MEMBERSHIP_FEES - discount;
            invoice.setSubTotal(subTotal);
        }

        setProMembershipDiscount(discount);
    }
}
