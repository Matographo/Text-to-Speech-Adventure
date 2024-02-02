package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.GetOutput;
import de.ttsa.ConsoleGame.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerRoomTest extends OpCodePlayerTesterClass {
    
    private final String PATH = TEST_FILE_PATH + "Room/";

    @Test
    public void testRoomEmpty() {
        Player player = new Player(PATH + "testRoomEmpty");
        player.play();
        resetTest();
    }

    @Test
    public void testRoomEmptyNameWithSpace() {
        Player player = new Player(PATH + "testRoomEmptyNameWithSpace");
        player.play();
        resetTest();
    }

    @Test
    public void testRoomEmptyWithCharAsNumber() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(PATH + "testRoomEmptyWithCharAsNumber");
            output.init();
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testRoomEmptyWithUnvalideRange() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(PATH + "testRoomEmptyWithUnvalideRange");
            output.init();
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testRoomWithSay() {
        String expected = "Hallo Welt";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testRoomWithSay");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }

}
