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

    @Test
    public void testInputEQStr() {
        final String expected = "hallo";
        SetInput input = new SetInput();
        input.makeInput(expected);
        Player player = new Player(TEST_FILE_PATH + "testInputEQStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
        input.reinit();
    }

    @Test
    public void testInputEQStrVar() {
        final String expected = "0";
        SetInput input = new SetInput();
        input.makeInput(expected);
        Player player = new Player(TEST_FILE_PATH + "testInputEQStrVar");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
        input.reinit();
    }

    @Test
    public void testInputInOrderDoubleOffOrder() {
        final String expected = "Hallo hallo hallo Hallo";
        SetInput input = new SetInput();
        input.makeInput(expected);
        Player player = new Player(TEST_FILE_PATH + "testInputInOrderDoubleOffOrder");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
        input.reinit();
    }

    @Test
    public void testInputInOrderOffOrderStr() {
        final String expected = "hallo";
        SetInput input = new SetInput();
        input.makeInput(expected);
        Player player = new Player(TEST_FILE_PATH + "testInputInOrderOffOrderStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
        input.reinit();
    }

    @Test
    public void testInputOffOrderStr() {
        final String expected = "hallo";
        SetInput input = new SetInput();
        input.makeInput(expected);
        Player player = new Player(TEST_FILE_PATH + "testInputOffOrderStr");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
        input.reinit();
    }

    @Test
    public void testInputOffOrderStrAndStrVar() {
        final String expected = "H allo";
        SetInput input = new SetInput();
        input.makeInput(expected);
        Player player = new Player(TEST_FILE_PATH + "testInputOffOrderStrAndStrVar");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
        input.reinit();
    }

}
