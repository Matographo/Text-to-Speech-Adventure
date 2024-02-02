package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterActionTest extends OpCodeTestTesterClass {
    
    private final String PATH = TEST_FILE_PATH + "Action/";


    @Test
    public void testAction() {
        OpCodeTest test = new OpCodeTest(PATH + "testAction");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testActionWithActionCall() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionWithActionCall");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testActionWithNumArg() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionWithNumArg");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testActionUseNumArg() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseNumArg");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testActionUseStrArg() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseStrArg");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testActionUseNumVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseNumVar");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testActionUseStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseStrVar");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testActionUseMultipleArgVars() {
        OpCodeTest test = new OpCodeTest(PATH + "testActionUseMultipleArgVars");
        assertEquals(true, test.start());
        resetTest();
    }

    private void resetTest() {
        GameManager.clear();
    }
}
