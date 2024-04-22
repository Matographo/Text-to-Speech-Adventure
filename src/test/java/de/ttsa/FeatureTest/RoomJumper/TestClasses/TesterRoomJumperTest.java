package de.ttsa.FeatureTest.RoomJumper.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterRoomJumperTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public TesterRoomJumperTest() {
        super("RoomJumper");
    }



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
