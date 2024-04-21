package de.ttsa.TestClasses.CodeCompilerTester;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;
import de.ttsa.TestClasses.CodeCompilerTesterClass;

public class CompilerRoomTest extends CodeCompilerTesterClass {

    private final String PATH = TEST_FILE_PATH + "Room/";

    @Test
    public void testRoom() {
        final String fileName = "testRoom";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testRoomWithSay() {
        final String fileName = "testRoomWithSay";
        ArrayList<String> compiled = compileFiles(getContent(PATH + fileName));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
}
