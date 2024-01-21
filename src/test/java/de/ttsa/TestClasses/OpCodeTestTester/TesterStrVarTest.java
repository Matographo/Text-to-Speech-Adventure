package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterStrVarTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/StrVar/";


    @Test
    public void testStrVarOneWord() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrVarOneWord");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testStrVarMultipleWords() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrVarMultipleWords");
            assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testStrVarFalseName() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrVarFalseName");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testStrVarDoubleName() {
        try {
            OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testStrVarDoubleName");
            assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }

}
