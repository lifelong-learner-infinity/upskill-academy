package com.example.academy.services.program;

import com.example.academy.model.Program;
import com.example.academy.repository.ProgramRepository;
import com.example.academy.services.invoice.InvoiceService;

public class ProgramService {

    private final ProgramRepository repository = new ProgramRepository();
    InvoiceService invoiceService = new InvoiceService();

    public void saveProgram(int studentId, String programName, Integer quantity) {
        Program program = repository.findById(studentId);

        if(program == null) {
            Program newProgram = new Program();
            newProgram.setStudentId(studentId);
            newProgram.addToProgramMap(programName, quantity);
            newProgram.setProMembership(false);
            repository.save(newProgram);
        } else {
            program.addToProgramMap(programName, quantity);
            repository.update(program);
        }
    }

    public void saveProgram(int studentId, String coupon) {
        Program program = repository.findById(studentId);

        if(program != null) {
            program.addCoupon(coupon);
            repository.save(program);
        }
    }

    public void saveProgram(int studentId, boolean membershipFlag) {
        Program program = repository.findById(studentId);

        if(program != null) {
            program.setProMembership(membershipFlag);
            repository.save(program);
        }
    }

    public void generateInvoice(int studentId) {
        Program program = repository.findById(studentId);

        if(program != null) {
            invoiceService.generateInvoice(program);
        }
    }

    public Program getProgram(int studentId) {
        return repository.findById(studentId);
    }
}
