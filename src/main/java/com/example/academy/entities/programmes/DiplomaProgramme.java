package com.example.academy.entities.programmes;

import com.example.academy.constants.Constants;
import com.example.academy.entities.ProgrammeDetails;

public class DiplomaProgramme extends ProgrammeDetails {

    public DiplomaProgramme() {
        super.programmeCost = Constants.DIPLOMA_PROGRAMME_COST;
        super.proMembershipDiscount = Constants.DIPLOMA_PRO_MEMBERSHIP_DISCOUNT;
    }
}
