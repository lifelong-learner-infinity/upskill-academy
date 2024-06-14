package com.example.academy.commands;

import com.example.academy.constants.Constants;
import com.example.academy.enums.Coupons;
import com.example.academy.services.IProgramService;

import java.util.List;

public class ApplyCouponCommand implements ICommand {
    private final IProgramService programService;

    public ApplyCouponCommand(IProgramService programService) {
        this.programService = programService;
    }

    @Override
    public void execute(List<String> tokens) {
        Coupons coupons = Coupons.valueOf(tokens.get(Constants.ONE));
        programService.addCoupon(coupons);
    }
}
