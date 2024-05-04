package de.ttsa.FeatureTest.If.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterIf extends CodeTesterClass  {
    
    public CodeTesterIf() {
        super("If");
    }

    @Test
    public void testIf() {
        boolean result = testCode("testIf");
        assertEquals(true, result);
    }

    @Test
    public void testIfCalc() {
        boolean result = testCode("testIfCalc");
        assertEquals(true, result);
    }

    @Test
    public void testIfElseIf() {
        boolean result = testCode("testIfElseIf");
        assertEquals(true, result);
    }

    @Test
    public void testIfElseIfElse() {
        boolean result = testCode("testIfElseIfElse");
        assertEquals(true, result);
    }

    @Test
    public void testIfGE() {
        boolean result = testCode("testIfGE");
        assertEquals(true, result);
    }

    @Test
    public void testIfGT() {
        boolean result = testCode("testIfGT");
        assertEquals(true, result);
    }

    @Test
    public void testIfLE() {
        boolean result = testCode("testIfLE");
        assertEquals(true, result);
    }

    @Test
    public void testIfLT() {
        boolean result = testCode("testIfLT");
        assertEquals(true, result);
    }

    @Test
    public void testIfNE() {
        boolean result = testCode("testIfNE");
        assertEquals(true, result);
    }

    @Test
    public void testIfStrEQStr() {
        boolean result = testCode("testIfStrEQStr");
        assertEquals(true, result);
    }

    @Test
    public void testIfStrVarEQStr() {
        boolean result = testCode("testIfStrVarEQStr");
        assertEquals(true, result);
    }

    @Test
    public void testIfWithElse() {
        boolean result = testCode("testIfWithElse");
        assertEquals(true, result);
    }

    @Test
    public void testIfWithLongCalc() {
        boolean result = testCode("testIfWithLongCalc");
        assertEquals(true, result);
    }

    @Test
    public void testIfWithTwoVar() {
        boolean result = testCode("testIfWithTwoVar");
        assertEquals(true, result);
    }

    @Test
    public void testIfWithVar() {
        boolean result = testCode("testIfWithVar");
        assertEquals(true, result);
    }
}
