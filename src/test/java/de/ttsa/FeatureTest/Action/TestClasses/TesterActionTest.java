package de.ttsa.FeatureTest.Action.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterActionTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    public TesterActionTest() {
        super("Action");
    }



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
