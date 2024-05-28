package com.example.academy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.example.academy.Main.handleProgram;

public class MainTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void cleanUp() {
        System.setOut(standardOut);
    }

    @Test
    public void shouldHandleProgramAction() {
        // given
        String data = "ADD_PROGRAMME CERTIFICATION 1";

        // when
        handleProgram(data);

        // then
        assertEquals("", outputStreamCaptor.toString());
    }

    @Test
    public void shouldHandleProMembership() {
        // given
        String data = "ADD_PRO_MEMBERSHIP";

        // when
        handleProgram(data);

        // then
        assertEquals("", outputStreamCaptor.toString());
    }

    @Test
    public void shouldHandleCouponAddition() {
        // given
        String data = "APPLY_COUPON DEAL_G20";

        // when
        handleProgram(data);

        // then
        assertEquals("", outputStreamCaptor.toString());
    }

    @Test
    public void shouldHandleInvoiceGeneration() {
        // given
        String data = "PRINT_BILL";

        // when
        handleProgram(data);

        // then
        assertEquals("", outputStreamCaptor.toString());
    }
}