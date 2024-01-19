package de.ttsa.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterSayTest {

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/OpCodeTestTester/TestFiles/";
    
    @Test
    public void testSayFixString() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayFixString");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayMultipleFixString() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayMultipleFixStringsAtOnce");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayMultipleSaysFixStrings() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayMultipleSaysFixStrings");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayFixNumber() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayFixNumber");
        assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }
}
