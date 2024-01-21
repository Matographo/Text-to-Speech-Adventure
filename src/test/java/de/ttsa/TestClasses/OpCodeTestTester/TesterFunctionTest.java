package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;

public class TesterFunctionTest {

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Functioning/";

    @Test
    public void testEmptyFile() {
        try {
        new OpCodeTest(TEST_FILE_PATH + "testEmptyFile");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testNoneExistingFile() {
        try {
        new OpCodeTest(TEST_FILE_PATH + "jkflasodijasdfadsfjajiewofewfaksdknawifowejfwf");
        fail();
        } catch (Exception e) {
        }
    }
    
}
