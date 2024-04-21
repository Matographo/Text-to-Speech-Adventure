package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompileStrVarTest extends CodeCompilerTesterClass {

    private final String PATH = TEST_FILE_PATH + "StrVar/";

    @Test
    public void testStrVar() {
        final String fileName = "testStrVar";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testStrVarJustName() {
        final String fileName = "testStrVarJustName";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
}
