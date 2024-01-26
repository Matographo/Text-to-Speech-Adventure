package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterSayTest {

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Say/";
    
    @Test
    public void testSayFixString() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayFixStringWithoutRoom");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayMultipleFixString() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayMultipleFixStringsAtOnceWithoutRoom");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayMultipleSaysFixStrings() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayMultipleSaysFixStringsWithoutRoom");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayFixNumber() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayFixNumber");
        assertEquals(false, test.start());
    }

    @Test
    public void testSayNumVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayNumVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayStrVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayFixStringAndStrVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayFixStringAndStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayNumVarAndFixString() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayNumVarAndFixString");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayStrVarAndNumVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayStrVarAndNumVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayNonExistingVar() {
        OpCodeTest test = new OpCodeTest(TEST_FILE_PATH + "testSayNonExistingVar");
        assertEquals(false, test.start());
    }
    

}
