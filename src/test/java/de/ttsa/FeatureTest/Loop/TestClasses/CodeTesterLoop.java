package de.ttsa.FeatureTest.Loop.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterLoop extends CodeTesterClass  {
    
    public CodeTesterLoop() {
        super("Loop");
    }

        @Test
    public void testLoopCount() {
        boolean result = testCode("testLoopCount");
        assertEquals(true, result);
    }

    @Test
    public void testLoopCountVar() {
        boolean result = testCode("testLoopCountVar");
        assertEquals(true, result);
    }

    @Test
    public void testLoopIf() {
        boolean result = testCode("testLoopIf");
        assertEquals(true, result);
    }

    @Test
    public void testLoopTrue() {
        boolean result = testCode("testLoopTrue");
        assertEquals(true, result);
    }

    @Test
    public void testLoopTrueWithBreak() {
        boolean result = testCode("testLoopTrueWithBreak");
        assertEquals(true, result);
    }
}
