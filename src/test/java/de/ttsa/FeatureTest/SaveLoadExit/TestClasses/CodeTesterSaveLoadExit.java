package de.ttsa.FeatureTest.SaveLoadExit.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterSaveLoadExit extends CodeTesterClass  {
    
    public CodeTesterSaveLoadExit() {
        super("SaveLoadExit");
    }

    @Test
    public void testExit() {
        boolean result = testCode("testExit");
        assertEquals(true, result);
    }

    @Test
    public void testLoad() {
        boolean result = testCode("testLoad");
        assertEquals(true, result);
    }

    @Test
    public void testSave() {
        boolean result = testCode("testSave");
        assertEquals(true, result);
    }
}
