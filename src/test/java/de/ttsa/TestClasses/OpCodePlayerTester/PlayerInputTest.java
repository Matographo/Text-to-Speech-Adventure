package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerInputTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Input/";

    @Test
    public void testInputEQStr() {
        Player player = new Player(TEST_FILE_PATH + "testInputEQStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testInputEQStrVar() {
        Player player = new Player(TEST_FILE_PATH + "testInputEQStrVar");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testInputInOrderDoubleOffOrder() {
        Player player = new Player(TEST_FILE_PATH + "testInputInOrderDoubleOffOrder");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testInputInOrderOffOrderStr() {
        Player player = new Player(TEST_FILE_PATH + "testInputInOrderOffOrderStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testInputOffOrderStr() {
        Player player = new Player(TEST_FILE_PATH + "testInputOffOrderStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testInputOffOrderStrAndStrVar() {
        Player player = new Player(TEST_FILE_PATH + "testInputOffOrderStrAndStrVar");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

}
