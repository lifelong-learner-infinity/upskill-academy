package com.example.academy.config;

import com.example.academy.commands.*;
import com.example.academy.entities.BillingDetails;
import com.example.academy.entities.IBillingDetails;
import com.example.academy.entities.ProgramEnrollment;
import com.example.academy.services.*;

public class ApplicationConfig {
    private final ProgramEnrollment programEnrollment = new ProgramEnrollment();
    private final IProgramService programService = new ProgramService(programEnrollment);
    private final IBillingDetails billingDetails = new BillingDetails();
    private final ICartService cartService = new CartService(programEnrollment, billingDetails);
    private final ICouponDiscountService couponDiscountService = new CouponDiscountService(programEnrollment, billingDetails);
    private final IBillService billService = new BillService(programEnrollment, billingDetails, cartService, couponDiscountService);
    private final CommandInvoker commandInvoker = new CommandInvoker();

    private final AddProgramCommand addProgramCommand = new AddProgramCommand(programService);
    private final ApplyCouponCommand applyCouponCommand = new ApplyCouponCommand(programService);
    private final AddProMembershipCommand addProMembershipCommand = new AddProMembershipCommand(programService);
    private final PrintBillCommand printBillCommand = new PrintBillCommand(billService);


    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("ADD_PROGRAMME", addProgramCommand);
        commandInvoker.register("APPLY_COUPON", applyCouponCommand);
        commandInvoker.register("ADD_PRO_MEMBERSHIP", addProMembershipCommand);
        commandInvoker.register("PRINT_BILL", printBillCommand);
        return commandInvoker;
    }
}
