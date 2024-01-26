package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.SetInput;
import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerInputTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Input/";

    @Test
    public void testInput() {
        final String expected = "Hallo Welt";
        SetInput input = new SetInput();
        input.makeInput(expected);
        assertEquals(null, GameManager.input);
        Player player = new Player(TEST_FILE_PATH + "testInput");
        player.play();
        assertEquals(expected, GameManager.input);
        GameManager.clear();
        input.reinit();
    }

}
