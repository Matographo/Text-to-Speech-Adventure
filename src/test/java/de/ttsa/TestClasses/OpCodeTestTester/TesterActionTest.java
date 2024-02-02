package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterActionTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Action/";


    @Test
    public void testAction() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testAction");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testActionWithActionCall() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testActionWithActionCall");
        assertEquals(true, test.start());
        resetTest();
    }

    private void resetTest() {
        GameManager.clear();
    }
}
