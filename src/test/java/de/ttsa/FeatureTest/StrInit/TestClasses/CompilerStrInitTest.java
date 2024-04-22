package de.ttsa.FeatureTest.StrInit.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;

public class CompilerStrInitTest extends CodeCompilerTesterClass {
    

    public CompilerStrInitTest() {
        super();
        featureName = "StrInit";
    }

    @Test
    public void testStrDec() {
        String testName = "testStrDec";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testStrDecWithVar() {
        String testName = "testStrDecWithVar";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }
}
