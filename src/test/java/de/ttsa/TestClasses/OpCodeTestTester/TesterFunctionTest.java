package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterFunctionTest {

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Functioning/";

    @Test
    public void testEmptyFile() {
        new OpCodeTest(TEST_FILE_PATH + "testEmptyFile");
    }

    @Test
    public void testNoneExistingFile() {
        try {
        new OpCodeTest(TEST_FILE_PATH + "jkflasodijasdfadsfjajiewofewfaksdknawifowejfwf");
        fail();
        } catch (Exception e) {
            assertEquals(true, true);
        }
    }
    
}
