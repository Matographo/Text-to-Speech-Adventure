package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterStrDecTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "StrDec/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testStrDec() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrDec");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrDecWithOtherStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrDecWithOtherStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrDecMultipleStringsAndVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrDecMultipleStringsAndVar");
        assertEquals(true, test.start());
    }


    // ------------------------- Fail Tests -------------------------


    
}
