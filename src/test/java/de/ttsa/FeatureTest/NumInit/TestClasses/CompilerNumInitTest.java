package de.ttsa.FeatureTest.NumInit.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;

public class CompilerNumInitTest extends CodeCompilerTesterClass {
    

    public CompilerNumInitTest() {
        super();
        featureName = "NumInit";
    }

    @Test
    public void testNumDec() {
        String testName = "testNumDec";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testNumDecAddition() {
        String testName = "testNumDecAddition";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testNumDecBreckets() {
        String testName = "testNumDecBreckets";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testNumDecDiv() {
        String testName = "testNumDecDiv";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testNumDecMulti() {
        String testName = "testNumDecMulti";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testNumDecSetVar() {
        String testName = "testNumDecSetVar";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testNumDecSub() {
        String testName = "testNumDecSub";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }
}
