package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterFunctionTest extends OpCodeTestTesterClass {


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Function/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testEmptyFile() {
        new OpCodeTest(PATH + "testEmptyFile");
    }



// ------------------------- Fail Tests -------------------------



    @Test
    public void testNoneExistingFile() {
        try {
        new OpCodeTest(PATH + "jkflasodijasdfadsfjajiewofewfaksdknawifowejfwf");
        fail();
        } catch (Exception e) {
        }
    }


    
}
