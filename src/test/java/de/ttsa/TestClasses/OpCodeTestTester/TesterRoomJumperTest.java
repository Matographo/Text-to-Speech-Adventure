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
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testRoomJumperWithoutRoomAndSpaceInName() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithoutRoomAndSpaceInName");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testRoomJumperWithoutRoomAsString() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithoutRoomAsString");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testRoomJumperWithoutRoomWithSpecialChar() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithoutRoomWithSpecialChar");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }
    
}
