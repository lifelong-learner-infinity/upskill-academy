package com.example.academy.services;

import com.example.academy.services.program.ProgramService;
import com.example.academy.utils.CouponType;
import com.example.academy.utils.ProgramType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InvoiceServiceTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final int studentId = 1;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void cleanUp() {
        System.setOut(standardOut);
    }

    @Test
    public void testGenerateInvoiceWithB4G1() {
        // given
        ProgramService programService = new ProgramService();
        programService.saveProgram(studentId, ProgramType.CERTIFICATION.name(), 1);
        programService.saveProgram(studentId, ProgramType.DEGREE.name(), 1);
        programService.saveProgram(studentId, ProgramType.DIPLOMA.name(), 2);
        programService.saveProgram(studentId, CouponType.DEAL_G20.name());

        // when
        programService.generateInvoice(studentId);

        // then
        assertEquals("SUB_TOTAL 13000.00\nCOUPON_DISCOUNT B4G1 2500.00\nTOTAL_PRO_DISCOUNT 0.00\nPRO_MEMBERSHIP_FEE 0.00\nENROLLMENT_FEE 0.00\nTOTAL 10500.00", outputStreamCaptor.toString());
    }

    @Test
    public void testGenerateInvoiceWithDealG20() {
        // given
        ProgramService programService = new ProgramService();
        programService.saveProgram(studentId, ProgramType.DEGREE.name(), 1);
        programService.saveProgram(studentId, ProgramType.DIPLOMA.name(), 2);
        programService.saveProgram(studentId, CouponType.DEAL_G20.name());
        programService.saveProgram(studentId, CouponType.DEAL_G5.name());

        // when
        programService.generateInvoice(studentId);

        // then
        assertEquals("SUB_TOTAL 10000.00\nCOUPON_DISCOUNT DEAL_G20 2000.00\nTOTAL_PRO_DISCOUNT 0.00\nPRO_MEMBERSHIP_FEE 0.00\nENROLLMENT_FEE 0.00\nTOTAL 8000.00", outputStreamCaptor.toString());
    }

    @Test
    public void testGenerateInvoiceWithDealG5() {
        // given
        ProgramService programService = new ProgramService();
        programService.saveProgram(studentId, ProgramType.CERTIFICATION.name(), 2);
        programService.saveProgram(studentId, ProgramType.DIPLOMA.name(), 1);
        programService.saveProgram(studentId, true);
        programService.saveProgram(studentId, CouponType.DEAL_G5.name());

        // when
        programService.generateInvoice(studentId);

        // then
        assertEquals("SUB_TOTAL 8555.00\nCOUPON_DISCOUNT DEAL_G5 427.75\nTOTAL_PRO_DISCOUNT 145.00\nPRO_MEMBERSHIP_FEE 200.00\nENROLLMENT_FEE 0.00\nTOTAL 8127.25", outputStreamCaptor.toString());
    }
}
