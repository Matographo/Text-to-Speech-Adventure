package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterSaveLoadExitTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "SaveLoadExit/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSaveSimpleGame() throws IOException {
        OpCodeTest test = new OpCodeTest(PATH + "testSaveSimpleGame");
        assertEquals(true, test.start());
    }

    @Test
    public void testLoadSimpleGame() throws IOException {
        OpCodeTest test = new OpCodeTest(PATH + "testLoadSimpleGame");
        assertEquals(true, test.start());
    }

    @Test
    public void testExitSimpleGameWithoutSave() throws IOException {
        OpCodeTest test = new OpCodeTest(PATH + "testExitSimpleGameWithoutSave");
        assertEquals(true, test.start());
    }

    @Test
    public void testExitSimpleGameWithSave() throws IOException {
        OpCodeTest test = new OpCodeTest(PATH + "testExitSimpleGameWithSave");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
