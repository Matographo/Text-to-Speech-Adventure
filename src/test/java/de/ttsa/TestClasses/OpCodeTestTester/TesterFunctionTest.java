package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterFunctionTest extends OpCodeTestTesterClass {

    private final String PATH = TEST_FILE_PATH + "Function/";

    @Test
    public void testEmptyFile() {
        new OpCodeTest(PATH + "testEmptyFile");
    }

    @Test
    public void testNoneExistingFile() {
        try {
        new OpCodeTest(PATH + "jkflasodijasdfadsfjajiewofewfaksdknawifowejfwf");
        fail();
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }
    
}
