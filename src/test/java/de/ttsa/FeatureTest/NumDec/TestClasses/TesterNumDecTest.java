package de.ttsa.FeatureTest.NumDec.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterNumDecTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public TesterNumDecTest() {
        super("NumDec");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testNumVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumVar");
        assertEquals(true, test.start());
    }




// ------------------------- Fail Tests -------------------------

    @Test
    public void testNumVarInvalideName() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumVarInvalideName");
        assertEquals(false, test.start());
    }
    
    @Test
    public void testNumVarFalseSyntax() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumVarFalseSyntax");
        assertEquals(false, test.start());
    }

}
