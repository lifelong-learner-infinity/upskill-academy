package com.example.academy.services;

import com.example.academy.entities.ProgrammeDetails;
import com.example.academy.enums.Coupons;
import com.example.academy.enums.Programmes;

public interface IProgramService {
    void addProgram(Programmes programmes, ProgrammeDetails details, int quantity);
    void addCoupon(Coupons coupons);
    void addProMembership();
}
