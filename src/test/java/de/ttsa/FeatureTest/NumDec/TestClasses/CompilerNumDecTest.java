package de.ttsa.FeatureTest.NumDec.TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class CompilerNumDecTest extends CodeCompilerTesterClass {

    public CompilerNumDecTest() {
        super();
        featureName = "NumDec";
    }

    @Test
    public void testNumVar() {
        final String fileName = "testNumVar";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testNumVarJustName() {
        final String fileName = "testNumVarJustName";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
}
