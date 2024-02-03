package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.GetOutput;
import de.ttsa.ConsoleGame.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerRoomJumperTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "RoomJumper/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testRoomJumperSwitchToRoom() {
        String expected = "Test Finished";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testRoomJumperSwitchToRoom");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }


// ------------------------- Fail Tests -------------------------




}
