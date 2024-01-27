package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterDebugInput {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/DebugInput/";


    @Test
    public void testDebugInput() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testDebugInput");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testDebugInputWithStrVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testDebugInputWithStrVar");
        assertEquals(true, test.start());
        resetTest();
    }

    private void resetTest() {
        GameManager.clear();
    }
}
