package de.ttsa.FeatureTest.StrInit.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterStrInitTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public TesterStrInitTest() {
        super("StrInit");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testStrDec() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrDec");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrDecWithOtherStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrDecWithOtherStrVar");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrDecMultipleStringsAndVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrDecMultipleStringsAndVar");
        assertEquals(true, test.start());
    }


    // ------------------------- Fail Tests -------------------------


    
}
