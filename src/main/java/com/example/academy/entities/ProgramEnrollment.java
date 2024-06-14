package com.example.academy.entities;

import com.example.academy.enums.Coupons;
import com.example.academy.enums.MembershipStatus;
import com.example.academy.enums.Programmes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramEnrollment {

    private final Map<Programmes, ProgrammeDetails> listOfProgrammes;
    private final Map<Programmes, Integer> programQuantity;
    private MembershipStatus membershipStatus;
    private final List<Coupons> couponsList;

    public ProgramEnrollment() {
        this.listOfProgrammes = new HashMap<>();
        this.programQuantity = new HashMap<>();
        this.couponsList = new ArrayList<>();
        this.membershipStatus = MembershipStatus.EMPTY;
    }

    public void addProgram(Programmes programmes, ProgrammeDetails details) {
        this.listOfProgrammes.put(programmes, details);
    }

    public void addProgramQuantity(Programmes programmes, int quantity) {
        this.programQuantity.put(programmes, quantity);
    }

    public void addCoupon(Coupons coupons) {
        this.couponsList.add(coupons);
    }

    public void setProMembershipStatus() {
        this.membershipStatus = MembershipStatus.ADDED;
    }

    public Map<Programmes, ProgrammeDetails> getListOfProgrammes() {
        return listOfProgrammes;
    }

    public Map<Programmes, Integer> getProgramQuantity() {
        return programQuantity;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public List<Coupons> getCouponsList() {
        return couponsList;
    }
}