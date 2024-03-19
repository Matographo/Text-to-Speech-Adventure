package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerStrDecTest extends CodeCompilerTesterClass {
    

    private final String PATH = TEST_FILE_PATH + "StrDec/";

    @Test
    public void testStrDec() {
        String testName = "testStrDec";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testStrDecWithVar() {
        String testName = "testStrDecWithVar";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }
}
