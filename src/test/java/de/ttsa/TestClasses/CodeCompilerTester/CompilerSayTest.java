package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.ConsoleGame.Compiler.OpCodeTester.OpCodeTest;
import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerSayTest extends CodeCompilerTesterClass {


    private final String PATH = TEST_FILE_PATH + "Say/";

    @Test
    public void testSayText() {
        final String fileName = "testSayText";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
    
}
