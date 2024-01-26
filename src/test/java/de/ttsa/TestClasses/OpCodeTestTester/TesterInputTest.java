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

    @Test
    public void testInputEQStr() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testInputEQStr");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputInOrderDoubleOffOrder() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testInputInOrderDoubleOffOrder");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputInOrderOffOrderStr() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testInputInOrderOffOrderStr");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputOffOrderStr() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testInputOffOrderStr");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputEQStrVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testInputEQStrVar");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputOffOrderStrAndStrVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testInputOffOrderStrAndStrVar");
        assertEquals(true, test.start());
        resetTest();
    }




    private void resetTest() {
        GameManager.clear();
    }
}
