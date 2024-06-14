package com.example.academy.commands;

import com.example.academy.services.IBillService;

import java.util.List;

public class PrintBillCommand implements ICommand {
    private final IBillService billService;

    public PrintBillCommand(IBillService billService) {
        this.billService = billService;
    }

    @Override
    public void execute(List<String> tokens) {
        System.out.println(billService.calculateBill());
    }
}
