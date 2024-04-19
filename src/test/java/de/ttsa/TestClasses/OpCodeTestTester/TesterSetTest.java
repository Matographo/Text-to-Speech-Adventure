package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterSetTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Set/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSetJustSet() {
        OpCodeTest test = new OpCodeTest(PATH + "testSetJustSet");
        assertEquals(true, test.start());
    }

    @Test
    public void testSetWithRoom() {
        OpCodeTest test = new OpCodeTest(PATH + "testSetWithRoom");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
