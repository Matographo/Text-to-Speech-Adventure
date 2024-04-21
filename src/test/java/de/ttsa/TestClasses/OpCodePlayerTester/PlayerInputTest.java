package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerInputTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Input/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testInputEQStr() {
        Player player = new Player(PATH + "testInputEQStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputEQStrVar() {
        Player player = new Player(PATH + "testInputEQStrVar");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputInOrderDoubleOffOrder() {
        Player player = new Player(PATH + "testInputInOrderDoubleOffOrder");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputInOrderOffOrderStr() {
        Player player = new Player(PATH + "testInputInOrderOffOrderStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputOffOrderStr() {
        Player player = new Player(PATH + "testInputOffOrderStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputOffOrderStrAndStrVar() {
        Player player = new Player(PATH + "testInputOffOrderStrAndStrVar");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------




}
