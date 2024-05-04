package de.ttsa.FeatureTest.Input.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterInput extends CodeTesterClass  {
    
    public CodeTesterInput() {
        super("Input");
    }

    @Test
    public void testInput() {
        boolean result = testCode("testInput");
        assertEquals(true, result);
    }

    @Test
    public void testInputAnd() {
        boolean result = testCode("testInputAnd");
        assertEquals(true, result);
    }

    @Test
    public void testInputBigCondition() {
        boolean result = testCode("testInputBigCondition");
        assertEquals(true, result);
    }

    @Test
    public void testInputInOrderMultipleArgs() {
        boolean result = testCode("testInputInOrderMultipleArgs");
        assertEquals(true, result);
    }

    @Test
    public void testInputInOrderSet() {
        boolean result = testCode("testInputInOrderSet");
        assertEquals(true, result);
    }

    @Test
    public void testInputInOrderStr() {
        boolean result = testCode("testInputInOrderStr");
        assertEquals(true, result);
    }

    @Test
    public void testInputInOrderStrVar() {
        boolean result = testCode("testInputInOrderStrVar");
        assertEquals(true, result);
    }

    @Test
    public void testInputInOrderWithOffOrder() {
        boolean result = testCode("testInputInOrderWithOffOrder");
        assertEquals(true, result);
    }

    @Test
    public void testInputNot() {
        boolean result = testCode("testInputNot");
        assertEquals(true, result);
    }

    @Test
    public void testInputOccurance() {
        boolean result = testCode("testInputOccurance");
        assertEquals(true, result);
    }

    @Test
    public void testInputOccuranceRange() {
        boolean result = testCode("testInputOccuranceRange");
        assertEquals(true, result);
    }

    @Test
    public void testInputOccuranceRangeFromXToInfinit() {
        boolean result = testCode("testInputOccuranceRangeFromXToInfinit");
        assertEquals(true, result);
    }

    @Test
    public void testInputOccuranceRangeToX() {
        boolean result = testCode("testInputOccuranceRangeToX");
        assertEquals(true, result);
    }

    @Test
    public void testInputOffOrderMultipleArgs() {
        boolean result = testCode("testInputOffOrderMultipleArgs");
        assertEquals(true, result);
    }

    @Test
    public void testInputOffOrderSet() {
        boolean result = testCode("testInputOffOrderSet");
        assertEquals(true, result);
    }

    @Test
    public void testInputOffOrderStr() {
        boolean result = testCode("testInputOffOrderStr");
        assertEquals(true, result);
    }

    @Test
    public void testInputOffOrderStrVar() {
        boolean result = testCode("testInputOffOrderStrVar");
        assertEquals(true, result);
    }

    @Test
    public void testInputOnlyMode() {
        boolean result = testCode("testInputOnlyMode");
        assertEquals(true, result);
    }

    @Test
    public void testInputOr() {
        boolean result = testCode("testInputOr");
        assertEquals(true, result);
    }

    @Test
    public void testInputSet() {
        boolean result = testCode("testInputSet");
        assertEquals(true, result);
    }

    @Test
    public void testInputStr() {
        boolean result = testCode("testInputStr");
        assertEquals(true, result);
    }

    @Test
    public void testInputStrVar() {
        boolean result = testCode("testInputStrVar");
        assertEquals(true, result);
    }

    @Test
    public void testInputWithAllModifyer() {
        boolean result = testCode("testInputWithAllModifyer");
        assertEquals(true, result);
    }
}
