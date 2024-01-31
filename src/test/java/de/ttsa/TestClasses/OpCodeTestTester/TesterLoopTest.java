package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterLoopTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Loop/";


    @Test
    public void testLoop() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testLoop");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testLoopJustNumber() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testLoopJustNumber");
        assertEquals(true, test.start());
        resetTest();
    }
    @Test

    public void testLoopWhileTrue() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testLoopWhileTrue");
        assertEquals(true, test.start());
        resetTest();
    }


    private void resetTest() {
        GameManager.clear();
    }
}
