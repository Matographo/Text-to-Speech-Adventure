package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterSayTest {

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Say/";
    
    @Test
    public void testSayFixString() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayFixStringWithoutRoom");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayMultipleFixString() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayMultipleFixStringsAtOnceWithoutRoom");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayMultipleSaysFixStrings() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayMultipleSaysFixStringsWithoutRoom");
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

    @Test
    public void testSayNumVar() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayNumVar");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayStrVar() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayStrVar");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayFixStringAndStrVar() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayFixStringAndStrVar");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayNumVarAndFixString() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayNumVarAndFixString");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayStrVarAndNumVar() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayStrVarAndNumVar");
        assertEquals(true, test.start());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testSayNonExistingVar() {
        try {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayNonExistingVar");
        assertEquals(false, test.start());
        } catch (Exception e) {
            fail();
        }
    }
    

}
