package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerNumVarTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/NumVar/";

    @Test
    public void testNumVar() {
        Player player = new Player(TEST_FILE_PATH + "testNumVar");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Hallo"));
        assertEquals(5, GameManager.numVars.get("Hallo").getValue());
        GameManager.clear();
    }

    @Test
    public void testNumVarFalseSyntax() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumVarFalseSyntax");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumVarInvalideName() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumVarInvalideName");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            GameManager.clear();
        }
    }

}
