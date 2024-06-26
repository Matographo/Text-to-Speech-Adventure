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


    private void resetTest() {
        GameManager.clear();
    }
}
