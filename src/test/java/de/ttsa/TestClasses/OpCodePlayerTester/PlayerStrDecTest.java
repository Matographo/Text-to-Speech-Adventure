package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerStrDecTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/StrDec/";

    @Test
    public void testStrDec() {
        Player player = new Player(TEST_FILE_PATH + "testStrDec");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Var"));
        assertEquals("all", GameManager.strVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testStrDecWithOtherStrVar() {
        Player player = new Player(TEST_FILE_PATH + "testStrDecWithOtherStrVar");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Var"));
        assertEquals("all", GameManager.strVars.get("Var").getValue());
        GameManager.clear();
    }
}
