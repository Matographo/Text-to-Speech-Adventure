package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.Logic.Compiler.OpCodeTester.OpCodeTest;
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

    @Test
    public void testSayNumber() {
        final String fileName = "testSayNumber";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayNumVar() {
        final String fileName = "testSayNumVar";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayMultiple() {
        final String fileName = "testSayMultiple";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayStrVar() {
        final String fileName = "testSayStrVar";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayNumStrVar() {
        final String fileName = "testSayNumber";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

}
