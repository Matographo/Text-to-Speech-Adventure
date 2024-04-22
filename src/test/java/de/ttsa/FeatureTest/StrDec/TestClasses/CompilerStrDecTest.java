package de.ttsa.FeatureTest.StrDec.TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class CompilerStrDecTest extends CodeCompilerTesterClass {

    public CompilerStrDecTest() {
        super();
        featureName = "StrDec";
    }

    @Test
    public void testStrVar() {
        final String fileName = "testStrVar";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testStrVarJustName() {
        final String fileName = "testStrVarJustName";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
}
