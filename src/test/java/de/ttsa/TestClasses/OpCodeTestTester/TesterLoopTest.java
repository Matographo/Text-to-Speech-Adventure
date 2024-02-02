package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterLoopTest extends OpCodeTestTesterClass {
    

    private final String PATH = TEST_FILE_PATH + "Loop/";


    @Test
    public void testLoop() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoop");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testLoopJustNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoopJustNumber");
        assertEquals(true, test.start());
        resetTest();
    }
    
    @Test
    public void testLoopWhileTrue() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoopWhileTrue");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testLoopWithBreaker() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoopWithBreaker");
        assertEquals(true, test.start());
        resetTest();
    }


    private void resetTest() {
        GameManager.clear();
    }
}
