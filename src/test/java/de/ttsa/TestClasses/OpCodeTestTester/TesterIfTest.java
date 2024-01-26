package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterIfTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/If/";


    @Test
    public void testIf() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIf");
            assertEquals(true, test.start());
            resetTest();
    }

    @Test
    public void testIfWithVar() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfWithVar");
            assertEquals(true, test.start());
            resetTest();
    }

    @Test
    public void testIfWithTwoVars() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfWithTwoVars");
            assertEquals(true, test.start());
            resetTest();
    }

    @Test
    public void testIfLeftLowerRight() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfLeftLowerRight");
            assertEquals(true, test.start());
            resetTest();
    }

    @Test
    public void testIfLeftNERight() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfLeftNERight");
            assertEquals(true, test.start());
            resetTest();
    }

    @Test
    public void testIfLeftGERight() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfLeftGERight");
            assertEquals(true, test.start());
            resetTest();
    }

    @Test
    public void testIfWithCalc() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfWithCalc");
            assertEquals(true, test.start());
            resetTest();
    }

    @Test
    public void testIfWithCalcVar() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfWithCalcVar");
            assertEquals(true, test.start());
            resetTest();
    }


    private void resetTest() {
        GameManager.clear();
    }
}
