package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterRoomJumperTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "RoomJumper/";



// ------------------------- Accepted Tests -------------------------


    @Test
    public void testRoomJumperWithRoom() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomJumperWithRoom");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



    @Test
    public void testRoomJumperAndSpaceInName() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomJumperSpaceInName");
        assertEquals(false, test.start());
    }

    @Test
    public void testRoomJumperAsString() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomJumperAsString");
        assertEquals(false, test.start());
    }

    @Test
    public void testRoomJumperWithSpecialChar() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomJumperWithSpecialChar");
        assertEquals(false, test.start());
    }


    @Test
    public void testRoomJumperWithoutRoom() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomJumperWithoutRoom");
        assertEquals(false, test.start());
    }
    
}
