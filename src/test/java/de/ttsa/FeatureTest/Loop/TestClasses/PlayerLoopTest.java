package de.ttsa.FeatureTest.Loop.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerLoopTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerLoopTest() {
        super("Loop");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testLoop() {
        final int expected = 1;
        Player player = new Player(PATH + "testLoop.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testLoopWihleTrue() {
        final int expected = 1;
        Player player = new Player(PATH + "testLoopWhileTrue.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testLoopWithBreaker() {
        final int expected = 1;
        Player player = new Player(PATH + "testLoopWithBreaker.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testLoopJustNumber() {
        final int expected = 5;
        Player player = new Player(PATH + "testLoopJustNumber.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testLoopJustVar() {
        final int expected = 10;
        Player player = new Player(PATH + "testLoopJustVar.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
