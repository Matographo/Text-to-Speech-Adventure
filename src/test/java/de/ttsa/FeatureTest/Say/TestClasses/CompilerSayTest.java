package de.ttsa.FeatureTest.Say.TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class CompilerSayTest extends CodeCompilerTesterClass {


    public CompilerSayTest() {
        super();
        featureName = "Say";
    }

    @Test
    public void testSayText() {
        final String fileName = "testSayText";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayNumber() {
        final String fileName = "testSayNumber";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayNumVar() {
        final String fileName = "testSayNumVar";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayMultiple() {
        final String fileName = "testSayMultiple";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayStrVar() {
        final String fileName = "testSayStrVar";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testSayNumStrVar() {
        final String fileName = "testSayNumber";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

}
