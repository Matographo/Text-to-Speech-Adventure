package de.ttsa.TestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.ComCodeTester.CCodeTest;

public class TesterSayTest {

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestTester/TestFiles/";
    
    @Test
    public void testSayFixString() {
        try {
        CCodeTest test = new CCodeTest(TEST_FILE_PATH + "testSayFixString");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayMultipleFixString() {
        try {
        CCodeTest test = new CCodeTest(TEST_FILE_PATH + "testSayMultipleFixStringsAtOnce");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayMultipleSaysFixStrings() {
        try {
        CCodeTest test = new CCodeTest(TEST_FILE_PATH + "testSayMultipleSaysFixStrings");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }
}
