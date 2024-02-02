package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterDebugInputTest extends OpCodeTestTesterClass {
    
    private final String PATH = TEST_FILE_PATH + "DebugInput/";


    @Test
    public void testDebugInput() {
        OpCodeTest test = new OpCodeTest(PATH + "testDebugInput");
        assertEquals(true, test.start());
    }

    @Test
    public void testDebugInputWithStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testDebugInputWithStrVar");
        assertEquals(true, test.start());
    }
}
