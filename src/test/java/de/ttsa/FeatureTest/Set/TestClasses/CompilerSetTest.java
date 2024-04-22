package de.ttsa.FeatureTest.Set.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;

public class CompilerSetTest extends CodeCompilerTesterClass {
    

    public CompilerSetTest() {
        super();
        featureName = "Set";
    }

    @Test
    public void testSet() {
        String testName = "testSet";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testSetWithVar() {
        String testName = "testSetWithVar";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }

    @Test
    public void testSetWithRoom() {
        String testName = "testSetWithRoom";
        boolean result;
        result = test(testName);
        assertEquals(true, result);
    }
}
