package com.example.academy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    private int studentId;
    private final Map<String, Integer> programMap = new HashMap<>();
    private boolean proMembership;
    private final List<String> couponList = new ArrayList<>();

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Map<String, Integer> getProgramMap() {
        return programMap;
    }

    public void addToProgramMap(String programName, int quantity) {
        programMap.put(programName, quantity);
    }

    public boolean isProMembership() {
        return proMembership;
    }

    public void setProMembership(boolean proMembership) {
        this.proMembership = proMembership;
    }

    public List<String> getCouponList() {
        return couponList;
    }

    public void addCoupon(String coupon) {
        couponList.add(coupon);
    }

}
