package de.ttsa.FeatureTest.RoomJumper.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterRoomJumper extends CodeTesterClass  {
    
    public CodeTesterRoomJumper() {
        super("RoomJumper");
    }

    @Test
    public void testRoomJump() {
        boolean result = testCode("testRoomJump");
        assertEquals(true, result);
    }
}
