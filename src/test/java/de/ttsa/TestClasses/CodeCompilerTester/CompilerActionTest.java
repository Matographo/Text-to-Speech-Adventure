package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerActionTest extends CodeCompilerTesterClass {
    

    private final String PATH = TEST_FILE_PATH + "Action/";

    
    @Test
    public void testAction() {
        String testName = "testAction";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionCallActionWithMultipleParams() {
        String testName = "testActionCallActionWithMultipleParams";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionCallActionWithParam() {
        String testName = "testActionCallActionWithParam";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionCallActionWithParamVar() {
        String testName = "testActionCallActionWithParamVar";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionCallOtherAction() {
        String testName = "testActionCallOtherAction";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionMultipleParams() {
        String testName = "testActionMultipleParams";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionWithActionCall() {
        String testName = "testActionWithActionCall";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionWithCode() {
        String testName = "testActionWithCode";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionWithNumParam() {
        String testName = "testActionWithNumParam";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testActionStrParam() {
        String testName = "testActionStrParam";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }
}
