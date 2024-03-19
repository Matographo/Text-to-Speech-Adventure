package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerDebugTest extends CodeCompilerTesterClass {
    

    private final String PATH = TEST_FILE_PATH + "DebugInput/";

    @Test
    public void testDebug() {
        String testName = "testDebug";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testDebugWithVar() {
        String testName = "testDebugWithVar";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testDebugWithStrAndVar() {
        String testName = "testDebugWithStrAndVar";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }
}
