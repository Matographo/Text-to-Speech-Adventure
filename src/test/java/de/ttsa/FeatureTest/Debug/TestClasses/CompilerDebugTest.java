package de.ttsa.FeatureTest.Debug.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;

public class CompilerDebugTest extends CodeCompilerTesterClass {
    

    public CompilerDebugTest() {
        super();
        featureName = "Debug";
    }

    @Test
    public void testDebug() {
        String testName = "testDebug";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testDebugWithVar() {
        String testName = "testDebugWithVar";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testDebugWithStrAndVar() {
        String testName = "testDebugWithStrAndVar";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }
}
