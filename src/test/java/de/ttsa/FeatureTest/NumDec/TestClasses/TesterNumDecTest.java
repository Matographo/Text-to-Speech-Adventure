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
        OpCodeTest test = new OpCodeTest(PATH + "testNumVar.ta");
        assertEquals(true, test.start());
    }




// ------------------------- Fail Tests -------------------------

    @Test
    public void testNumVarInvalideName() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumVarInvalideName.ta");
        assertEquals(false, test.start());
    }
    
    @Test
    public void testNumVarFalseSyntax() {
        OpCodeTest test = new OpCodeTest(PATH + "testNumVarFalseSyntax.ta");
        assertEquals(false, test.start());
    }

}
