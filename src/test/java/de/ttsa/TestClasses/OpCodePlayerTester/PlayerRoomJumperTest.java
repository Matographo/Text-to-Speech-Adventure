package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.GetOutput;
import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerRoomJumperTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/RoomJumper/";

    @Test
    public void testRoomJumperSwitchToRoom() {
        String expected = "Test Finished";
        GetOutput output = new GetOutput();
        Player player = new Player(TEST_FILE_PATH + "testRoomJumperSwitchToRoom");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        GameManager.clear();
    }

}
