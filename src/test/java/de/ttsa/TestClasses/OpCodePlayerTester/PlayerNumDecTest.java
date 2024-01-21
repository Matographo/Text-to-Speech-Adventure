package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerNumDecTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/NumDec/";

    @Test
    public void testNumDec() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDec");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(10, GameManager.numVars.get("Zahl").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecWithString() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecWithString");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(10, GameManager.numVars.get("Zahl").getValue());
            fail();
        } catch (Exception e) {
        } finally {
            GameManager.clear();
        }
    }
}
