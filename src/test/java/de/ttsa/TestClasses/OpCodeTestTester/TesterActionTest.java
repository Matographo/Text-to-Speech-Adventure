package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterActionTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Action/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testAction() {
        OpCodeTest test = new OpCodeTest(PATH + "testAction");
        assertEquals(true, test.start());
    }

    @Test
    public void testActionWithActionCall() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionWithActionCall");
        assertEquals(true, test.start());
    }

    @Test
    public void testActionWithNumArg() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionWithNumArg");
        assertEquals(true, test.start());
    }

    @Test
    public void testActionUseNumArg() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseNumArg");
        assertEquals(true, test.start());
    }

    @Test
    public void testActionUseStrArg() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseStrArg");
        assertEquals(true, test.start());
    }

    @Test
    public void testActionUseNumVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseNumVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testActionUseStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testActionUseMultipleArgVars() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseMultipleArgVars");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
