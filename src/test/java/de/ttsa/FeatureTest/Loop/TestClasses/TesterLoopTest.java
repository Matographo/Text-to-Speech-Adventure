package de.ttsa.FeatureTest.Loop.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterLoopTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    public TesterLoopTest() {
        super("Loop");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testLoop() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoop");
        assertEquals(true, test.start());
    }

    @Test
    public void testLoopJustNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoopJustNumber");
        assertEquals(true, test.start());
    }
    
    @Test
    public void testLoopWhileTrue() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoopWhileTrue");
        assertEquals(true, test.start());
    }

    @Test
    public void testLoopWithBreaker() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoopWithBreaker");
        assertEquals(true, test.start());
    }

    @Test
    public void testLoopJustVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testLoopJustVar");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
