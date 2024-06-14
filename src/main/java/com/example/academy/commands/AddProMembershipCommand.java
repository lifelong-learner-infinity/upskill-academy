package com.example.academy.commands;

import com.example.academy.services.IProgramService;

import java.util.List;

public class AddProMembershipCommand implements ICommand {
    private final IProgramService programService;

    public AddProMembershipCommand(IProgramService programService) {
        this.programService = programService;
    }

    @Override
    public void execute(List<String> tokens) {
        programService.addProMembership();
    }
}
