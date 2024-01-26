package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterIfTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/If/";


    @Test
    public void testIf() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIf");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testIfWithVar() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfWithVar");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testIfWithTwoVars() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfWithTwoVars");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testIfLeftLowerRight() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfLeftLowerRight");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testIfLeftNERight() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfLeftNERight");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testIfLeftGERight() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testIfLeftGERight");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
        finally {
            resetTest();
        }
    }


    private void resetTest() {
        GameManager.clear();
    }
}
