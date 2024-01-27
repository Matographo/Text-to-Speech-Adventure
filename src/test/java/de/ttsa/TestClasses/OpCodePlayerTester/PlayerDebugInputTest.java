package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerDebugInputTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/DebugInput/";

    @Test
    public void testDebugInput() {
        Player player = new Player(TEST_FILE_PATH + "testDebugInput");
        player.play();
        assertEquals("input", GameManager.input);
        GameManager.clear();
    }

    @Test
    public void testDebugInputWithStrVar() {
        Player player = new Player(TEST_FILE_PATH + "testDebugInputWithStrVar");
        player.play();
        assertEquals("input", GameManager.input);
        GameManager.clear();
    }


}
