package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.ConsoleGame.Player.GameManager;

public class TesterNumDecTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/NumDec/";


    @Test
    public void testNumDec() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDec");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();

        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecWithString() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecWithString");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }  finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecWithStrVar() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecWithStrVar");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();

        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecCalcNegativeNumber() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcNegativeNumber");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();

        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecCalcNumberAndVar() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcNumberAndVar");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();

        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecCalcTwoNumbers() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcTwoNumbers");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecCalcWithBreckeds() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcWithBreckeds");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();

        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecCalcWithDoublePlus() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecCalcWithDoublePlus");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
        finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecNegativeNumber() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testNumDecNegativeNumber");
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
