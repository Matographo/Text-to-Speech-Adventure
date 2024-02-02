package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterStrDecTest extends OpCodeTestTesterClass {
    
    private final String PATH = TEST_FILE_PATH + "StrDec/";

    @Test
    public void testStrDec() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrDec");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrDecWithOtherStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrDecWithOtherStrVar");
        assertEquals(true, test.start());
    }
}
