package com.example.academy.entities.programmes;

import com.example.academy.constants.Constants;
import com.example.academy.entities.ProgrammeDetails;

public class DegreeProgramme extends ProgrammeDetails {

    public DegreeProgramme() {
        super.programmeCost = Constants.DEGREE_PROGRAMME_COST;
        super.proMembershipDiscount = Constants.DEGREE_PRO_MEMBERSHIP_DISCOUNT;
    }
}
