package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterRoomJumperTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/RoomJumper/";

    @Test
    public void testRoomJumperWithoutRoom() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithoutRoom");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testRoomJumperWithRoom() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithRoom");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testRoomJumperAndSpaceInName() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperSpaceInName");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testRoomJumperAsString() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperAsString");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testRoomJumperWithSpecialChar() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithSpecialChar");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }
    
}
