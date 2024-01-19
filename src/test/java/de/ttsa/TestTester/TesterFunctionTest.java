package de.ttsa.TestTester;

import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.ComCodeTester.CCodeTest;

public class TesterFunctionTest {

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestTester/TestFiles/";

    @Test
    public void testEmptyFile() {
        try {
        CCodeTest test = new CCodeTest(TEST_FILE_PATH + "testEmptyFile");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testNoneExistingFile() {
        try {
        CCodeTest test = new CCodeTest(TEST_FILE_PATH + "jkflasodijasdfadsfjajiewofewfaksdknawifowejfwf");
        fail();
        } catch (Exception e) {
        }
    }
    
}
