package de.ttsa.FeatureTest.RoomJumper.TestClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeCompilerTesterClass;
import de.ttsa.Logic.Compiler.CompilerSteps.OpCodeTest;

public class CompilerRoomJumperTest extends CodeCompilerTesterClass {

    public CompilerRoomJumperTest() {
        super();
        featureName = "RoomJumper";
    }

    @Test
    public void testRoomJump() {
        try {
        final String fileName = "testRoomJump";
        ArrayList<String> compiled = compileFiles(getContent(getFilePath(fileName)));
        OpCodeTest opCodeTest = new OpCodeTest();
        boolean test = opCodeTest.start(compiled);
        assertEquals(true, test);
        } catch (Exception e) {
            fail();
        }
    }
}
