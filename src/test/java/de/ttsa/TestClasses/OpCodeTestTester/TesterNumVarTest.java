package de.ttsa.TestClasses.OpCodeTestTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.TestClasses.OpCodeTestTesterClass;

public class TesterNumVarTest extends OpCodeTestTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "NumVar/";



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
