package com.example.academy;

import com.example.academy.controller.ProgramController;
import com.example.academy.utils.ActionType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final ProgramController programController = new ProgramController();

    public static void main(String[] args) {
        try {
            FileInputStream inputStream = new FileInputStream(args[0]);
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                handleProgram(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }

    public static void handleProgram(String actionString) {
        String[] data = actionString.split(" ");
        ActionType action = ActionType.valueOf(data[0]);
        switch (action) {
            case ADD_PROGRAMME:
             programController.addProgram(data[1], Integer.valueOf(data[2]));
             break;
            case APPLY_COUPON:
             programController.addCoupon(data[1]);
             break;
            case ADD_PRO_MEMBERSHIP:
             programController.addProMembership();
             break;
            case PRINT_BILL:
             programController.generateInvoice();
             break;
            default:
             System.out.println("Unknown action type: " + action);
        }
    }
}
