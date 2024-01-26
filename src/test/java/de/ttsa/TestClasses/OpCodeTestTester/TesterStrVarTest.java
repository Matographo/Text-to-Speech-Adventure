package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterStrVarTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/StrVar/";


    @Test
    public void testStrVarOneWord() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrVarOneWord");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrVarMultipleWords() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrVarMultipleWords");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrVarFalseName() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrVarFalseName");
        assertEquals(false, test.start());
    }

    @Test
    public void testStrVarDoubleName() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrVarDoubleName");
        assertEquals(false, test.start());
    }

}
