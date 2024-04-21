package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class CompilerSaveLoadExitTest extends CompilerRoomJumperTest {

    private final String PATH = TEST_FILE_PATH + "SaveLoadExit/";

    @Test
    public void testSave() {
        final String fileName = "testSave";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testLoad() {
        final String fileName = "testLoad";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testExit() {
        final String fileName = "testExit";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
}
