package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterStrDecTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/StrDec/";


    @Test
    public void testStrDec() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrDec");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrDecWithOtherStrVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrDecWithOtherStrVar");
        assertEquals(true, test.start());
    }
}
