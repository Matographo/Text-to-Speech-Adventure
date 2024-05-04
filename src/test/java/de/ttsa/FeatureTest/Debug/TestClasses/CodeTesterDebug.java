package de.ttsa.FeatureTest.Debug.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterDebug extends CodeTesterClass  {
    
    public CodeTesterDebug() {
        super("Debug");
    }

    @Test
    public void testDebug() {
        boolean result = testCode("testDebug");
        assertEquals(true, result);
    }

    @Test
    public void testDebugWithStrAndVar() {
        boolean result = testCode("testDebugWithStrAndVar");
        assertEquals(true, result);
    }

    @Test
    public void testDebugWithVar() {
        boolean result = testCode("testDebugWithVar");
        assertEquals(true, result);
    }
}
