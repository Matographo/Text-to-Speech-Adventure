package de.ttsa.FunctionTest.TestClasses;

import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterFunctionTest {


// ------------------------------ PATHS ------------------------------



private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/FunctionTest/";
private final String PATH;
private final String TEST_PATH = "/TestFiles/";

public TesterFunctionTest() {
    PATH = TEST_FILE_PATH + TEST_PATH;
}



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testEmptyFile() {
        new OpCodeTest(PATH + "testEmptyFile.ta");
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
