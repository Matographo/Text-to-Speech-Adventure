package de.ttsa.FeatureTest.SaveLoadExit.TestClasses;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterSaveLoadExitTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    public TesterSaveLoadExitTest() {
        super("SaveLoadExit");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSaveSimpleGame() throws IOException {
        OpCodeTest test = new OpCodeTest(PATH + "testSaveSimpleGame.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testLoadSimpleGame() throws IOException {
        OpCodeTest test = new OpCodeTest(PATH + "testLoadSimpleGame.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testExitSimpleGameWithoutSave() throws IOException {
        OpCodeTest test = new OpCodeTest(PATH + "testExitSimpleGameWithoutSave.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testExitSimpleGameWithSave() throws IOException {
        OpCodeTest test = new OpCodeTest(PATH + "testExitSimpleGameWithSave.ta");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
