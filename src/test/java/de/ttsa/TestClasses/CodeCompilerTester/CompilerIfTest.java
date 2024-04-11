package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerIfTest extends CodeCompilerTesterClass {
    

    private final String PATH = TEST_FILE_PATH + "If/";

    @Test
    public void testIf() {
        String testName = "testIf";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfCalc() {
        String testName = "testIfCalc";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfElseIf() {
        String testName = "testIfElseIf";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfElseIfElse() {
        String testName = "testIfElseIfElse";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfGE() {
        String testName = "testIfGE";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfGT() {
        String testName = "testIfGT";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfLE() {
        String testName = "testIfLE";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfLT() {
        String testName = "testIfLT";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfNE() {
        String testName = "testIfNE";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfWithElse() {
        String testName = "testIfWithElse";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfWithLongCalc() {
        String testName = "testIfWithLongCalc";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfWithTwoVar() {
        String testName = "testIfWithTwoVar";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfWithVar() {
        String testName = "testIfWithVar";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfStrEQStr() {
        String testName = "testIfStrEQStr";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }

    @Test
    public void testIfStrVarEQStr() {
        String testName = "testIfStrVarEQStr";
        boolean result;
        result = test(PATH, testName);
        assertEquals(true, result);
    }
}
