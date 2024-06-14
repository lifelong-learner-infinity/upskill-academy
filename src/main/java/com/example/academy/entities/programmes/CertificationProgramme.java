package com.example.academy.entities.programmes;

import com.example.academy.constants.Constants;
import com.example.academy.entities.ProgrammeDetails;

public class CertificationProgramme extends ProgrammeDetails {

    public CertificationProgramme() {
        super.programmeCost = Constants.CERTIFICATION_PROGRAMME_COST;
        super.proMembershipDiscount = Constants.CERTIFICATION_PRO_MEMBERSHIP_DISCOUNT;
    }
}
