package com.example.academy.entities.factory;

import com.example.academy.entities.ProgrammeDetails;
import com.example.academy.entities.programmes.CertificationProgramme;
import com.example.academy.entities.programmes.DegreeProgramme;
import com.example.academy.entities.programmes.DiplomaProgramme;
import com.example.academy.enums.Programmes;
import com.example.academy.exceptions.InvalidProgrammeException;

public class ProgramFactoryProducer {
    private static ProgrammeDetails getProgrammeDetailsFactory(Programmes programmes) {
        switch (programmes) {
            case CERTIFICATION: return new CertificationProgramme();
            case DIPLOMA: return new DiplomaProgramme();
            case DEGREE: return new DegreeProgramme();
        }
        return null;
    }

    public static ProgrammeDetails getProgrammeDetails(Programmes programmes) {
        ProgrammeDetails programFactory = getProgrammeDetailsFactory(programmes);
        if(programFactory == null) throw new InvalidProgrammeException("Programme is not valid");
        return programFactory;
    }
}
