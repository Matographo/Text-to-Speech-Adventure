package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.GetOutput;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerRoomTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Room/";

    @Test
    public void testRoomEmpty() {
        Player player = new Player(TEST_FILE_PATH + "testRoomEmpty");
        player.play();
    }

    @Test
    public void testRoomEmptyNameWithSpace() {
        Player player = new Player(TEST_FILE_PATH + "testRoomEmptyNameWithSpace");
        player.play();
    }

    @Test
    public void testRoomEmptyWithCharAsNumber() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testRoomEmptyWithCharAsNumber");
            output.init();
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            output.reinit();
        }
    }

    @Test
    public void testRoomEmptyWithUnvalideRange() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testRoomEmptyWithUnvalideRange");
            output.init();
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            output.reinit();
        }
    }

    @Test
    public void testRoomWithSay() {
        String expected = "Hallo Welt";
        GetOutput output = new GetOutput();
        Player player = new Player(TEST_FILE_PATH + "testRoomWithSay");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
    }

}
