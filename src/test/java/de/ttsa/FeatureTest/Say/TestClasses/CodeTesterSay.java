package de.ttsa.FeatureTest.Say.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterSay extends CodeTesterClass {

    public CodeTesterSay() {
        super("Say");
    }

    @Test
    public void testSayMultiple() {
        boolean result = testCode("testSayMultiple");
        assertEquals(true, result);
    }

    @Test
    public void testSayNumber() {
        boolean result = testCode("testSayNumber");
        assertEquals(true, result);
    }

    @Test
    public void testSayNumStrVar() {
        boolean result = testCode("testSayNumStrVar");
        assertEquals(true, result);
    }

    @Test
    public void testSayNumVar() {
        boolean result = testCode("testSayNumVar");
        assertEquals(true, result);
    }

    @Test
    public void testSayStrVar() {
        boolean result = testCode("testSayStrVar");
        assertEquals(true, result);
    }

    @Test
    public void testSayText() {
        boolean result = testCode("testSayText");
        assertEquals(true, result);
    }


    
}
