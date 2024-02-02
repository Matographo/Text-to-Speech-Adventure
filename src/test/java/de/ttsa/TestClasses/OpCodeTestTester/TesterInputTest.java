package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterInputTest extends OpCodeTestTesterClass {
    

    private final String PATH = TEST_FILE_PATH + "Input/";


    @Test
    public void testInput() {
        OpCodeTest test = new OpCodeTest(PATH + "testInput");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputEQStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputEQStr");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputInOrderDoubleOffOrder() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputInOrderDoubleOffOrder");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputInOrderOffOrderStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputInOrderOffOrderStr");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputOffOrderStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputOffOrderStr");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputEQStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputEQStrVar");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testInputOffOrderStrAndStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputOffOrderStrAndStrVar");
        assertEquals(true, test.start());
        resetTest();
    }




    private void resetTest() {
        GameManager.clear();
    }
}
