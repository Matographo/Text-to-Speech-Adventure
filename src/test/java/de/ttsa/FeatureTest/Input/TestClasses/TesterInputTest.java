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
        OpCodeTest test = new OpCodeTest(PATH + "testInput");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputEQStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputEQStr");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputInOrderDoubleOffOrder() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputInOrderDoubleOffOrder");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputInOrderOffOrderStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputInOrderOffOrderStr");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputOffOrderStr() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputOffOrderStr");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputEQStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputEQStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testInputOffOrderStrAndStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testInputOffOrderStrAndStrVar");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}