package com.example.academy.services;

import com.example.academy.entities.ProgramEnrollment;
import com.example.academy.entities.ProgrammeDetails;
import com.example.academy.enums.Coupons;
import com.example.academy.enums.Programmes;

public class ProgramService implements IProgramService {
    private final ProgramEnrollment programEnrollment;

    public ProgramService(ProgramEnrollment programEnrollment) {
        this.programEnrollment = programEnrollment;
    }

    @Override
    public void addProgram(Programmes programmes, ProgrammeDetails details, int quantity) {
        // Validate data. If not correct, then throw error
        programEnrollment.addProgram(programmes, details);
        programEnrollment.addProgramQuantity(programmes, quantity);
    }

    @Override
    public void addCoupon(Coupons coupons) {
        // Validate data. If not correct, then throw error
        programEnrollment.addCoupon(coupons);
    }

    @Override
    public void addProMembership() {
        programEnrollment.setProMembershipStatus();
    }
}
