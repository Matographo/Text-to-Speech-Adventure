package de.ttsa.FeatureTest.Say.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodeTestTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class TesterSayTest extends OpCodeTestTesterClass {


// ------------------------------ PATHS ------------------------------



    public TesterSayTest() {
        super("Say");
    }
    


// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSayFixString() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayFixStringWithoutRoom.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayMultipleSaysFixStrings() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayMultipleSaysFixStrings.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayNumVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayNumVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayStrVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayFixStringAndStrVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayFixStringAndStrVar.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayNumVarAndFixString() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayNumVarAndFixString.ta");
        assertEquals(true, test.start());
    }

    @Test
    public void testSayStrVarAndNumVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayStrVarAndNumVar.ta");
        assertEquals(true, test.start());
    }
    


// ------------------------- Fail Tests -------------------------


    @Test
    public void testSayNonExistingVar() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayNonExistingVar.ta");
        assertEquals(false, test.start());
    }

    @Test
    public void testSayFixNumber() {
        OpCodeTest test = new OpCodeTest(PATH + "testSayFixNumber.ta");
        assertEquals(false, test.start());
    }

}
