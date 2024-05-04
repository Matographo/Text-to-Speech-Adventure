package de.ttsa.FeatureTest.Room.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.CodeTesterClass;

public class CodeTesterRoom extends CodeTesterClass  {
    
    public CodeTesterRoom() {
        super("Room");
    }

    @Test
    public void testRoom() {
        boolean result = testCode("testRoom");
        assertEquals(true, result);
    }

    @Test
    public void testRoomWithSay() {
        boolean result = testCode("testRoomWithSay");
        assertEquals(true, result);
    }
}
