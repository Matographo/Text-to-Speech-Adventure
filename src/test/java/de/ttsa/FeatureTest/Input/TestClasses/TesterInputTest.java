package de.ttsa.FeatureTest.Input.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterInputTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    public TesterInputTest() {
        super("Input");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testInput() {
        OpCodeTest test = new OpCodeTest(PATH + "testInput.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputEQStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputEQStr.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputInOrderDoubleOffOrder() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputInOrderDoubleOffOrder.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputInOrderOffOrderStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputInOrderOffOrderStr.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputOffOrderStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputOffOrderStr.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputEQStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputEQStrVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputOffOrderStrAndStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputOffOrderStrAndStrVar.ta");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
