package com.example.academy.commands;

import com.example.academy.constants.Constants;
import com.example.academy.entities.ProgrammeDetails;
import com.example.academy.entities.factory.ProgramFactoryProducer;
import com.example.academy.enums.Programmes;
import com.example.academy.services.IProgramService;

import java.util.List;

public class AddProgramCommand implements ICommand {
    private final IProgramService programService;

    public AddProgramCommand(IProgramService programService) {
        this.programService = programService;
    }

    @Override
    public void execute(List<String> tokens) {
        Programmes programmes = Programmes.valueOf(tokens.get(Constants.ONE));
        ProgrammeDetails details = ProgramFactoryProducer.getProgrammeDetails(programmes);
        int quantity = Integer.parseInt(tokens.get(Constants.TWO));
        programService.addProgram(programmes, details, quantity);
    }
}
