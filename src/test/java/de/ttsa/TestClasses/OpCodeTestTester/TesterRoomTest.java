package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterRoomTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Room/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testRoomEmpty() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomEmpty");
        assertEquals(true, test.start());
    }

    @Test
    public void testRoomNameWithSpace() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomEmptyNameWithSpace");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



    @Test
    public void testRoomWithCharAsNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomEmptyWithCharAsNumber");
        assertEquals(false, test.start());
    }
    
    @Test
    public void testRoomWithUnvalideRange() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomEmptyWithUnvalideRange");
        assertEquals(false, test.start());
    }


}
