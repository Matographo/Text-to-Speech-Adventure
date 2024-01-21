package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterNumVarTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/NumVar/";


    @Test
    public void testNumVar() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumVar");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        } finally {
            resetTest();
        }
    }

    @Test
    public void testNumVarInvalideName() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumVarInvalideName");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        } finally {
            resetTest();
        }
    }

    @Test
    public void testNumVarFalseSyntax() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumVarFalseSyntax");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        } finally {
            resetTest();
        }
    }


    private void resetTest() {
        GameManager.clear();
    }

}
