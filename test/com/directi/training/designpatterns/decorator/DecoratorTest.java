package com.directi.training.designpatterns.decorator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DecoratorTest
{
    private Application _application1 = new Application(9, 1500, 115);
    private Application _application2 = new Application(9.5f, 1550, 30);
    private Application _application3 = new Application(9.5f, 600, 117);
    private Application _application4 = new Application(4.0f, 1550, 119);
    private Registrar _registrar = new Registrar();

    @Test
    public void testAllApplicantsExceptTheLastAreSelectedOnGPACriteria()
    {
        Criteria criteria = evaluationWithGPA();
        assertTrue(_registrar.evaluate(_application1, criteria));
        assertTrue(_registrar.evaluate(_application2, criteria));
        assertTrue(_registrar.evaluate(_application3, criteria));
        assertFalse(_registrar.evaluate(_application4, criteria));
    }

    @Test
    public void testFirstTwoApplicantsAreSelectedOnGPAAndGRECriteria()
    {
        Criteria criteria = evaluationWithGPAAndGRE();
        assertTrue(_registrar.evaluate(_application1, criteria));
        assertTrue(_registrar.evaluate(_application2, criteria));
        assertFalse(_registrar.evaluate(_application3, criteria));
        assertFalse(_registrar.evaluate(_application4, criteria));
    }

    @Test
    public void testFirstAndThirdApplicantsAreSelectedOnGPAAndTOEFLCriteria()
    {
        Criteria criteria = evaluationWithGPAAndTOEFL();
        assertTrue(_registrar.evaluate(_application1, criteria));
        assertFalse(_registrar.evaluate(_application2, criteria));
        assertTrue(_registrar.evaluate(_application3, criteria));
        assertFalse(_registrar.evaluate(_application4, criteria));
    }

    @Test
    public void testOnlyFirstApplicantIsSelectedOnGRE_GPAAndTOEFLCriteria()
    {
        Criteria criteria = evaluationWithGPA_GREAndTOFEL();
        assertTrue(_registrar.evaluate(_application1, criteria));
        assertFalse(_registrar.evaluate(_application2, criteria));
        assertFalse(_registrar.evaluate(_application3, criteria));
        assertFalse(_registrar.evaluate(_application4, criteria));
    }

    private Criteria evaluationWithGPA_GREAndTOFEL()
    {
        return new GRETOEFL();
    }

    private Criteria evaluationWithGPAAndGRE()
    {
        return new GREEval();
    }

    private Criteria evaluationWithGPA()
    {
        return new GPAEval();
    }

    private Criteria evaluationWithGPAAndTOEFL()
    {
        return new TOEFL();
    }

}
