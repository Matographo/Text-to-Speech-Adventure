package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerActionTest {

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Action/";

    @Test
    public void testAction() {
        Player player = new Player(TEST_FILE_PATH + "testAction");
        player.play();
        GameManager.clear();
    }

    @Test
    public void testActionWithActionCall() {
        Player player = new Player(TEST_FILE_PATH + "testActionWithActionCall");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testActionCallOtherAction() {
        Player player = new Player(TEST_FILE_PATH + "testActionCallOtherAction");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }
    
}
