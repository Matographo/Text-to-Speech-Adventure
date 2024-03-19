package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerLoop extends CodeCompilerTesterClass {

    private final String PATH = TEST_FILE_PATH + "Loop/";

    @Test
    public void testLoopCount() {
        String testName = "testLoopCount";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testLoopCountVar() {
        String testName = "testLoopCountVar";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testLoopIf() {
        String testName = "testLoopIf";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testLoopTrue() {
        String testName = "testLoopTrue";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testLoopTrueWithBreak() {
        String testName = "testLoopTrueWithBreak";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }
}
