package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerLoopTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Loop/";

    @Test
    public void testLoop() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testLoop");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testLoopWihleTrue() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testLoopWhileTrue");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testLoopWithBreaker() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testLoopWithBreaker");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testLoopJustNumber() {
        final int expected = 5;
        Player player = new Player(TEST_FILE_PATH + "testLoopJustNumber");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }
}
