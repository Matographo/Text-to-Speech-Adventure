package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterIfTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "If/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testIf() {
        OpCodeTest test = new OpCodeTest(PATH + "testIf");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithTwoVars() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithTwoVars");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfLeftLowerRight() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfLeftLowerRight");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfLeftNERight() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfLeftNERight");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfLeftGERight() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfLeftGERight");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithCalc() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithCalc");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithCalcVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithCalcVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithElse() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithElse");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithElseIf() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithElseIf");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithStrVarEQStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithStrVarEQStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfStrEQStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfStrEQStr");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfStrNEStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfStrNEStr");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfStrVarEQStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfStrVarEQStr");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
