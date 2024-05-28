package com.example.academy.services;

import com.example.academy.model.Program;
import com.example.academy.services.program.ProgramService;
import com.example.academy.utils.CouponType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class ProgramServiceTest {

    int studentId = 1;

    @Test
    public void testSaveProgram() {
        // given
        ProgramService programService = new ProgramService();

        // when
        programService.saveProgram(studentId, "CERTIFICATION", 2);

        // then
        Program program = programService.getProgram(studentId);
        assertEquals(2, program.getProgramMap().get("CERTIFICATION"));
    }

    @Test
    public void testAddCoupon() {
        // given
        ProgramService programService = new ProgramService();

        // when
        programService.saveProgram(studentId, "CERTIFICATION", 2);
        programService.saveProgram(studentId, CouponType.DEAL_G20.name());

        // then
        List<String> couponList = programService.getProgram(studentId).getCouponList();
        assertTrue(couponList.contains(CouponType.DEAL_G20.name()));
    }

    @Test
    public void testAddProMembership() {
        // given
        ProgramService programService = new ProgramService();

        // when
        programService.saveProgram(studentId, "CERTIFICATION", 2);
        programService.saveProgram(studentId, true);

        // then
        boolean proMembership = programService.getProgram(studentId).isProMembership();
        assertTrue(proMembership);
    }
}

