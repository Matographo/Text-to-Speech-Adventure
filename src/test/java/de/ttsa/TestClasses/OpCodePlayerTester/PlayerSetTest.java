package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerSetTest {
    

    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Set/";

    @Test
    public void testSetJustSet() {
        Player player = new Player(TEST_FILE_PATH + "testSetJustSet");
        player.play();
        assertEquals(3, GameManager.sets.get("Attack").getStr().size());
        GameManager.clear();
    }

    @Test
    public void testSetWithRoom() {
        Player player = new Player(TEST_FILE_PATH + "testSetWithRoom");
        player.play();
        assertEquals(3, GameManager.sets.get("Attack").getStr().size());
        GameManager.clear();
    }

    @Test
    public void testSetWithVariable() {
        Player player = new Player(TEST_FILE_PATH + "testSetWithVariable");
        player.play();
        assertEquals(1, GameManager.sets.get("Attack").getStr().size());
        assertEquals(1, GameManager.sets.get("Attack").getVar().size());
        GameManager.clear();
    }

    @Test
    public void testSetInIf() {
        Player player = new Player(TEST_FILE_PATH + "testSetInIf");
        player.play();
        assertEquals(1, GameManager.numVars.get("Varr").getValue());
        GameManager.clear();
    }
}
