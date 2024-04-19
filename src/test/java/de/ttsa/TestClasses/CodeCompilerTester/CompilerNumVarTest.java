package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerNumVarTest extends CodeCompilerTesterClass {

    private final String PATH = TEST_FILE_PATH + "NumVar/";

    @Test
    public void testNumVar() {
        final String fileName = "testNumVar";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testNumVarJustName() {
        final String fileName = "testNumVarJustName";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
}
