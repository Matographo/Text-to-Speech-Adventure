package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerSetTest extends CodeCompilerTesterClass {
    

    private final String PATH = TEST_FILE_PATH + "Set/";

    @Test
    public void testSet() {
        String testName = "testSet";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testSetWithVar() {
        String testName = "testSetWithVar";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }
}
