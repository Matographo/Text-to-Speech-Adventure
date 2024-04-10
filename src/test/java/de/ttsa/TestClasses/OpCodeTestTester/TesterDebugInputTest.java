package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterDebugInputTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "DebugInput/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testDebugInput() {
        OpCodeTest test = new OpCodeTest(PATH + "testDebugInput");
        assertEquals(true, test.start());
    }

    @Test
    public void testDebugInputWithStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testDebugInputWithStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testDebugInputWithStrVarAndString() {
        OpCodeTest test = new OpCodeTest(PATH + "testDebugInputWithStrVarAndString");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
