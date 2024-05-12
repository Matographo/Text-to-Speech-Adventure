package de.ttsa.FeatureTest.Set.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterSetTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public TesterSetTest() {
        super("Set");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSetJustSet() {
        OpCodeTest test = new OpCodeTest(PATH + "testSetJustSet.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testSetWithRoom() {
        OpCodeTest test = new OpCodeTest(PATH + "testSetWithRoom.ta");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



}
