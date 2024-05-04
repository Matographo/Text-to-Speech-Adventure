package de.ttsa.FeatureTest.NumInit.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterNumInit extends CodeTesterClass  {
    
    public CodeTesterNumInit() {
        super("NumInit");
    }

    @Test
    public void testNumDec() {
        boolean result = testCode("testNumDec");
        assertEquals(true, result);
    }

    @Test
    public void testNumDecAddition() {
        boolean result = testCode("testNumDecAddition");
        assertEquals(true, result);
    }

    @Test
    public void testNumDecBreckets() {
        boolean result = testCode("testNumDecBreckets");
        assertEquals(true, result);
    }

    @Test
    public void testNumDecDiv() {
        boolean result = testCode("testNumDecDiv");
        assertEquals(true, result);
    }

    @Test
    public void testNumDecMulti() {
        boolean result = testCode("testNumDecMulti");
        assertEquals(true, result);
    }

    @Test
    public void testNumDecSetVar() {
        boolean result = testCode("testNumDecSetVar");
        assertEquals(true, result);
    }

    @Test
    public void testNumDecSub() {
        boolean result = testCode("testNumDecSub");
        assertEquals(true, result);
    }
}
