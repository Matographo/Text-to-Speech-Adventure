package de.ttsa.FeatureTest.StrDec.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterStrDec extends CodeTesterClass {
    

    public CodeTesterStrDec() {
        super("StrDec");
    }

    @Test
    public void testStrVar() {
        boolean result = testCode("testStrVar");
        assertEquals(true, result);
    }

    @Test
    public void testNumVarJustName() {
        boolean result = testCode("testStrVarJustName");
        assertEquals(true, result);
    }
}
