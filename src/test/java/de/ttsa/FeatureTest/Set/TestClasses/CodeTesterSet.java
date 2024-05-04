package de.ttsa.FeatureTest.Set.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterSet extends CodeTesterClass  {
    
    public CodeTesterSet() {
        super("Set");
    }

    @Test
    public void testSet() {
        boolean result = testCode("testSet");
        assertEquals(true, result);
    }

    @Test
    public void testSetWithRoom() {
        boolean result = testCode("testSetWithRoom");
        assertEquals(true, result);
    }

    @Test
    public void testSetWithVar() {
        boolean result = testCode("testSetWithVar");
        assertEquals(true, result);
    }
}
