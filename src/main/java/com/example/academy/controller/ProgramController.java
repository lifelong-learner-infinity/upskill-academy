package com.example.academy.controller;

import com.example.academy.services.program.ProgramService;

public class ProgramController {

    ProgramService programService = new ProgramService();
    int studentId = 1;

    public void addProgram(String programName, Integer quantity) {
        programService.saveProgram(studentId, programName, quantity);
    }

    public void addCoupon(String coupon) {
        programService.saveProgram(studentId, coupon);
    }

    public void addProMembership() {
        programService.saveProgram(studentId, true);
    }

    public void generateInvoice() {
        programService.generateInvoice(studentId);
    }
}
