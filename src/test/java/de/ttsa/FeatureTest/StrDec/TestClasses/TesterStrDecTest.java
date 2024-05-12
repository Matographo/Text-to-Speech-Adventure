package de.ttsa.FeatureTest.StrDec.TestClasses;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TesterStrDecTest extends OpCodeTestTesterClass {



// ------------------------------ PATHS ------------------------------



    public TesterStrDecTest() {
        super("StrDec");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testStrVarOneWord() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrVarOneWord.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testStrVarMultipleWords() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrVarMultipleWords.ta");
        assertEquals(true, test.start());
    }



// ------------------------- Fail Tests -------------------------



    @Test
    public void testStrVarFalseName() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrVarFalseName.ta");
        assertEquals(false, test.start());
    }

    @Test
    public void testStrVarDoubleName() {
        OpCodeTest test = new OpCodeTest(PATH + "testStrVarDoubleName.ta");
        assertEquals(false, test.start());
    }


    
}
