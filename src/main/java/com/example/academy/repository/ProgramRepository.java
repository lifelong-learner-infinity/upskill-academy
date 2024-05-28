package com.example.academy.repository;

import com.example.academy.model.Program;

import java.util.ArrayList;
import java.util.List;

public class ProgramRepository {

    private final List<Program> list = new ArrayList<>();

    public Program findById(int studentId) {
        for (Program program : list) {
            if (program.getStudentId() == studentId) {
                return program;
            }
        }
        return null;
    }

    public void save(Program program) {
        list.add(program);
    }

    public void update(Program program) {
        int idx = 0;
        for(int i=0; i< list.size(); i++) {
            if(list.get(i).getStudentId() == program.getStudentId()) {
                idx = i;
            }
        }

        list.set(idx, program);
    }

}
