package de.ttsa.FeatureTest.NumInit.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterNumInitTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    public TesterNumInitTest() {
        super("NumInit");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testNumDec() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDec.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecCalcNegativeNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcNegativeNumber.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecCalcNumberAndVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcNumberAndVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecCalcTwoNumbers() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcTwoNumbers.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecCalcWithBreckeds() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcWithBreckeds.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecNegativeNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecNegativeNumber.ta");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



    @Test
    public void testNumDecWithString() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecWithString.ta");
        assertEquals(false, test.start());
    }

    @Test
    public void testNumDecWithStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecWithStrVar.ta");
        assertEquals(false, test.start());
    }

    @Test
    public void testNumDecCalcWithDoublePlus() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcWithDoublePlus.ta");
        assertEquals(false, test.start());
    }

}
