package com.example.academy.services.invoice;

import com.example.academy.model.Program;

public interface Discount {

    void calculateDiscount(Program program, Invoice invoice);
}
