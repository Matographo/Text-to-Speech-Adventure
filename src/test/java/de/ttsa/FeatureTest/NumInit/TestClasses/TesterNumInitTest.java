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
        OpCodeTest test = new OpCodeTest(PATH + "testNumDec");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecCalcNegativeNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcNegativeNumber");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecCalcNumberAndVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcNumberAndVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecCalcTwoNumbers() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcTwoNumbers");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecCalcWithBreckeds() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcWithBreckeds");
        assertEquals(true, test.start());
    }

    @Test
    public void testNumDecNegativeNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecNegativeNumber");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



    @Test
    public void testNumDecWithString() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecWithString");
        assertEquals(false, test.start());
    }

    @Test
    public void testNumDecWithStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecWithStrVar");
        assertEquals(false, test.start());
    }

    @Test
    public void testNumDecCalcWithDoublePlus() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumDecCalcWithDoublePlus");
        assertEquals(false, test.start());
    }

}
