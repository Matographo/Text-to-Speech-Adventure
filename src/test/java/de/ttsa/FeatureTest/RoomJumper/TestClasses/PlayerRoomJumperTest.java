package de.ttsa.FeatureTest.RoomJumper.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.GetOutput;
import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerRoomJumperTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerRoomJumperTest() {
        super("RoomJumper");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testRoomJumperSwitchToRoom() {
        String expected = "Test Finished";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testRoomJumperSwitchToRoom.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }


// ------------------------- Fail Tests -------------------------




}
