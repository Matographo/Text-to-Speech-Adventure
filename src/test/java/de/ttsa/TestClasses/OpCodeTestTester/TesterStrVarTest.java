package de.ttsa.TestClasses.OpCodeTestTester;

import de.ttsa.TestClasses.OpCodeTestTesterClass;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;


public class TesterStrVarTest extends OpCodeTestTesterClass {


    private final String PATH = TEST_FILE_PATH + "StrVar/";


    @Test
    public void testStrVarOneWord() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrVarOneWord");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrVarMultipleWords() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrVarMultipleWords");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrVarFalseName() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrVarFalseName");
        assertEquals(false, test.start());
    }

    @Test
    public void testStrVarDoubleName() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrVarDoubleName");
        assertEquals(false, test.start());
    }

}
