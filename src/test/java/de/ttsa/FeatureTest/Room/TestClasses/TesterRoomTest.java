package de.ttsa.FeatureTest.Room.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterRoomTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public TesterRoomTest() {
        super("Room");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testRoomEmpty() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomEmpty");
        assertEquals(true, test.start());
    }

    @Test
    public void testRoomNameWithSpace() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomEmptyNameWithSpace");
        assertEquals(true, test.start());
    }


// ------------------------- Fail Tests -------------------------



    @Test
    public void testRoomWithCharAsNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomEmptyWithCharAsNumber");
        assertEquals(false, test.start());
    }
    
    @Test
    public void testRoomWithUnvalideRange() {
        OpCodeTest test = new OpCodeTest(PATH + "testRoomEmptyWithUnvalideRange");
        assertEquals(false, test.start());
    }


}
