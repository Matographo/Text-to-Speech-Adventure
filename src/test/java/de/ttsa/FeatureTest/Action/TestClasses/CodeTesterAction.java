package de.ttsa.FeatureTest.Action.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterAction extends CodeTesterClass  {
    
    public CodeTesterAction() {
        super("Action");
    }

    @Test
    public void testAction() {
        boolean result = testCode("testAction");
        assertEquals(true, result);
    }

    @Test
    public void testActionCallActionWithMultipleParams() {
        boolean result = testCode("testActionCallActionWithMultipleParams");
        assertEquals(true, result);
    }

    @Test
    public void testActionCallActionWithParam() {
        boolean result = testCode("testActionCallActionWithParam");
        assertEquals(true, result);
    }

    @Test
    public void testActionCallActionWithParamVar() {
        boolean result = testCode("testActionCallActionWithParamVar");
        assertEquals(true, result);
    }

    @Test
    public void testActionCallOtherAction() {
        boolean result = testCode("testActionCallOtherAction");
        assertEquals(true, result);
    }

    @Test
    public void testActionMultipleParams() {
        boolean result = testCode("testActionMultipleParams");
        assertEquals(true, result);
    }

    @Test
    public void testActionMultipleParamsWithUsage() {
        boolean result = testCode("testActionMultipleParamsWithUsage");
        assertEquals(true, result);
    }

    @Test
    public void testActionWithActionCall() {
        boolean result = testCode("testActionWithActionCall");
        assertEquals(true, result);
    }

    @Test
    public void testActionWithCode() {
        boolean result = testCode("testActionWithCode");
        assertEquals(true, result);
    }

    @Test
    public void testActionWithNumParam() {
        boolean result = testCode("testActionWithNumParam");
        assertEquals(true, result);
    }

    @Test
    public void testActionWithStrParam() {
        boolean result = testCode("testActionWithStrParam");
        assertEquals(true, result);
    }
    
}
