package de.ttsa.FeatureTest.Loop.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;

public class CompilerLoopTest extends CodeCompilerTesterClass {

    public CompilerLoopTest() {
        super();
        featureName = "Loop";
    }

    @Test
    public void testLoopCount() {
        String testName = "testLoopCount";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testLoopCountVar() {
        String testName = "testLoopCountVar";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testLoopIf() {
        String testName = "testLoopIf";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testLoopTrue() {
        String testName = "testLoopTrue";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testLoopTrueWithBreak() {
        String testName = "testLoopTrueWithBreak";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }
}
