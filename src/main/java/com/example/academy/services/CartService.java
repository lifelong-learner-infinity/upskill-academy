package com.example.academy.services;

import com.example.academy.constants.Constants;
import com.example.academy.entities.IBillingDetails;
import com.example.academy.entities.ProgramEnrollment;
import com.example.academy.entities.ProgrammeDetails;
import com.example.academy.enums.Programmes;

import java.util.Map;

public class CartService implements ICartService {
    private final ProgramEnrollment programEnrollment;
    private final IBillingDetails billingDetails;

    public CartService(ProgramEnrollment programEnrollment, IBillingDetails billingDetails) {
        this.programEnrollment = programEnrollment;
        this.billingDetails = billingDetails;
    }

    @Override
    public void calculateTotalCost() {
        double totalProgramFees = 0.00;
        int totalQuantity = 0;

        Map<Programmes, ProgrammeDetails> listOfProgrammes = programEnrollment.getListOfProgrammes();
        Map<Programmes, Integer> programQuantity = programEnrollment.getProgramQuantity();

        for(Programmes programmes: listOfProgrammes.keySet()) {
            double programCost = listOfProgrammes.get(programmes).getProgrammeCost();
            int quantity = programQuantity.get(programmes);
            totalProgramFees += programCost * quantity;
            totalQuantity += quantity;
        }

        billingDetails.setTotalProgrammeFee(totalProgramFees);
        billingDetails.setTotalQuantity(totalQuantity);
    }

    @Override
    public void calculateTotalProMembershipDiscount() {
        double proMembershipDiscount = 0.00;
        double proMembershipFee = Constants.PRO_MEMBERSHIP_FEE;

        Map<Programmes, ProgrammeDetails> listOfProgrammes = programEnrollment.getListOfProgrammes();
        Map<Programmes, Integer> programQuantity = programEnrollment.getProgramQuantity();

        for(Programmes programmes: listOfProgrammes.keySet()) {
            double programCost = listOfProgrammes.get(programmes).getProgrammeCost();
            int quantity = programQuantity.get(programmes);
            double discount = listOfProgrammes.get(programmes).getProMembershipDiscount();
            proMembershipDiscount += programCost * quantity * discount;
        }

        billingDetails.setProMembershipDiscount(proMembershipDiscount);
        billingDetails.setProMembershipFee(proMembershipFee);
        billingDetails.setTotalProgrammeFee(billingDetails.getTotalProgrammeFee() + proMembershipFee - proMembershipDiscount);
    }
}
