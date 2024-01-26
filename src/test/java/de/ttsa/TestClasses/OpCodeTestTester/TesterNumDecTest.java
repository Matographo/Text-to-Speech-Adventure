package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterNumDecTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/NumDec/";


    @Test
    public void testNumDec() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDec");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testNumDecWithString() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecWithString");
        assertEquals(false, test.start());
        resetTest();
    }

    @Test
    public void testNumDecWithStrVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecWithStrVar");
        assertEquals(false, test.start());
        resetTest();
    }

    @Test
    public void testNumDecCalcNegativeNumber() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcNegativeNumber");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testNumDecCalcNumberAndVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcNumberAndVar");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testNumDecCalcTwoNumbers() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcTwoNumbers");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testNumDecCalcWithBreckeds() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcWithBreckeds");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testNumDecCalcWithDoublePlus() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcWithDoublePlus");
        assertEquals(false, test.start());
        resetTest();
    }

    @Test
    public void testNumDecNegativeNumber() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecNegativeNumber");
        assertEquals(true, test.start());
        resetTest();
    }


    private void resetTest() {
        GameManager.clear();
    }


}
