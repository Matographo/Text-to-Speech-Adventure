package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterSaveLoadExitTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/SaveLoadExit/";

    @Test
    public void testSaveSimpleGame() throws IOException {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSaveSimpleGame");
        assertEquals(true, test.start());
    }

    @Test
    public void testLoadSimpleGame() throws IOException {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testLoadSimpleGame");
        assertEquals(true, test.start());
    }
}
