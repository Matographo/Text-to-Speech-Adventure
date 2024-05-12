package de.ttsa.FeatureTest.Room.TestClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.HelpClasses.GetOutput;
import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerRoomTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerRoomTest() {
        super("Room");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testRoomEmpty() {
        Player player = new Player(PATH + "testRoomEmpty.ta");
        player.play();
        resetTest();
    }

    @Test
    public void testRoomEmptyNameWithSpace() {
        Player player = new Player(PATH + "testRoomEmptyNameWithSpace.ta");
        player.play();
        resetTest();
    }

    @Test
    public void testRoomWithSay() {
        String expected = "Hallo Welt";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testRoomWithSay.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



    @Test
    public void testRoomEmptyWithCharAsNumber() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(PATH + "testRoomEmptyWithCharAsNumber.ta");
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
            Player player = new Player(PATH + "testRoomEmptyWithUnvalideRange.ta");
            output.init();
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            output.reinit();
            resetTest();
        }
    }


}
