package de.ttsa.FeatureTest.NumDec.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterNumDec extends CodeTesterClass {
    

    public CodeTesterNumDec() {
        super("NumDec");
    }

    @Test
    public void testNumVar() {
        boolean result = testCode("testNumVar");
        assertEquals(true, result);
    }

    @Test
    public void testNumVarJustName() {
        boolean result = testCode("testNumVarJustName");
        assertEquals(true, result);
    }
}
