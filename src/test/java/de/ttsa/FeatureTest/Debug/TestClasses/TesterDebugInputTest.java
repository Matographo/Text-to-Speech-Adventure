package de.ttsa.FeatureTest.Debug.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterDebugInputTest extends OpCodeTestTesterClass {
    

// ------------------------------ PATHS ------------------------------



    public TesterDebugInputTest() {
        super("Debug");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testDebugInput() {
        OpCodeTest test = new OpCodeTest(PATH + "testDebugInput.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testDebugInputWithStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testDebugInputWithStrVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testDebugInputWithStrVarAndString() {
        OpCodeTest test = new OpCodeTest(PATH + "testDebugInputWithStrVarAndString.ta");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
