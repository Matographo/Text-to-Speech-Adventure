package de.ttsa.FeatureTest.StrInit.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterStrInit extends CodeTesterClass  {

    public CodeTesterStrInit() {
        super("StrInit");
    }

    @Test
    public void testStrDec() {
        boolean result = testCode("testStrDec");
        assertEquals(true, result);
    }

    @Test
    public void testStrDecWithVar() {
        boolean result = testCode("testStrDecWithVar");
        assertEquals(true, result);
    }
}
