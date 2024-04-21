package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerInputTest extends CodeCompilerTesterClass {
    

        private final String PATH = TEST_FILE_PATH + "Input/";

    @Test
    public void testInput() {
        final String fileName = "testInput";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
}
