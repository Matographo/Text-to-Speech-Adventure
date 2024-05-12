package de.ttsa.FeatureTest.If.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterIfTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    public TesterIfTest() {
        super("If");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testIf() {
        OpCodeTest test = new OpCodeTest(PATH + "testIf.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithTwoVars() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithTwoVars.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfLeftLowerRight() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfLeftLowerRight.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfLeftNERight() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfLeftNERight.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfLeftGERight() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfLeftGERight.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithCalc() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithCalc.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithCalcVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithCalcVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithElse() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithElse.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithElseIf() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithElseIf.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithStrVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfWithStrVarEQStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfWithStrVarEQStrVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfStrEQStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfStrEQStr.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfStrNEStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfStrNEStr.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testIfStrVarEQStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testIfStrVarEQStr.ta");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
