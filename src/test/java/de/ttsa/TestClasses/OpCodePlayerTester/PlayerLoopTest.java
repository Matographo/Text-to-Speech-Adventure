package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerLoopTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Loop/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testLoop() {
        final int expected = 1;
        Player player = new Player(PATH + "testLoop");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testLoopWihleTrue() {
        final int expected = 1;
        Player player = new Player(PATH + "testLoopWhileTrue");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testLoopWithBreaker() {
        final int expected = 1;
        Player player = new Player(PATH + "testLoopWithBreaker");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testLoopJustNumber() {
        final int expected = 5;
        Player player = new Player(PATH + "testLoopJustNumber");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
