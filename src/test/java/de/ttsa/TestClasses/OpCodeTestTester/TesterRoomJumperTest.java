package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterRoomJumperTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/RoomJumper/";

    @Test
    public void testRoomJumperWithoutRoom() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithoutRoom");
            assertEquals(false, test.start());
    }

    @Test
    public void testRoomJumperWithRoom() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithRoom");
            assertEquals(true, test.start());
    }

    @Test
    public void testRoomJumperAndSpaceInName() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperSpaceInName");
            assertEquals(false, test.start());
    }

    @Test
    public void testRoomJumperAsString() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperAsString");
            assertEquals(false, test.start());
    }

    @Test
    public void testRoomJumperWithSpecialChar() {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomJumperWithSpecialChar");
            assertEquals(false, test.start());
    }
    
}
