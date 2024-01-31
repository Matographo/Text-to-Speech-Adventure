package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterSetTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Set/";


    @Test
    public void testSetJustSet() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSetJustSet");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testSetWithRoom() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSetWithRoom");
        assertEquals(true, test.start());
        resetTest();
    }

    private void resetTest() {
        GameManager.clear();
    }
}
