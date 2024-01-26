package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterRoomTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Room/";

    @Test
    public void testRoomEmpty() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomEmpty");
        assertEquals(true, test.start());
    }

    @Test
    public void testRoomNameWithSpace() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomEmptyNameWithSpace");
        assertEquals(false, test.start());
    }

    @Test
    public void testRoomWithCharAsNumber() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomEmptyWithCharAsNumber");
        assertEquals(false, test.start());
    }

    @Test
    public void testRoomWithUnvalideRange() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testRoomEmptyWithUnvalideRange");
        assertEquals(false, test.start());
    }
}
