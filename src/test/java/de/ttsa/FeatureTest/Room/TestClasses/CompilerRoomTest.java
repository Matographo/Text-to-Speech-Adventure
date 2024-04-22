package de.ttsa.FeatureTest.Room.TestClasses;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class CompilerRoomTest extends CodeCompilerTesterClass {

    public CompilerRoomTest() {
        super();
        featureName = "Room";
    }

    @Test
    public void testRoom() {
        final String fileName = "testRoom";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }

    @Test
    public void testRoomWithSay() {
        final String fileName = "testRoomWithSay";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
    }
}
