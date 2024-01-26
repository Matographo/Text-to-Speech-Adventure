package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterInputTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Input/";


    @Test
    public void testInput() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testInput");
        assertEquals(true, test.start());
        resetTest();
    }


    private void resetTest() {
        GameManager.clear();
    }
}
