package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterNumVarTest extends OpCodeTestTesterClass {
    
    private final String PATH = TEST_FILE_PATH + "NumVar/";


    @Test
    public void testNumVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumVar");
        assertEquals(true, test.start());
        resetTest();
    }

    @Test
    public void testNumVarInvalideName() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumVarInvalideName");
        assertEquals(false, test.start());
        resetTest();
    }

    @Test
    public void testNumVarFalseSyntax() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumVarFalseSyntax");
        assertEquals(false, test.start());
        resetTest();
    }


    private void resetTest() {
        GameManager.clear();
    }

}
