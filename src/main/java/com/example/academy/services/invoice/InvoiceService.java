package com.example.academy.services.invoice;

import com.example.academy.model.Program;

public class InvoiceService {

    public static final double ENROLLMENT_FEES_THRESHOLD = 6666d;
    public static final double ENROLLMENT_FEES = 500d;


    public void generateInvoice(Program program) {
        Invoice invoice = new Invoice();
        Coupon coupon = new Coupon();
        Membership membership = new Membership();

        // Get subtotal and total quantity
        invoice.calculateSubTotal(program.getProgramMap());

        // Get pro membership discount
        membership.calculateDiscount(program, invoice);

        // Get coupon discount
        coupon.calculateDiscount(program, invoice);

        // Check if enrollment fees is applicable
        double enrollmentFees = 0;
        if((invoice.getSubTotal() - coupon.getCouponDiscount()) < ENROLLMENT_FEES_THRESHOLD && invoice.getTotalQuantity() > 0) {
            enrollmentFees = ENROLLMENT_FEES;
        }

        invoice.printInvoice(invoice, coupon, membership, enrollmentFees);
    }
}
