package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerStrVarTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/StrVar/";

    @Test
    public void testStrVarOneWord() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testStrVarOneWord");
            player.play();
            assertEquals(true, GameManager.strVars.containsKey("Hallo"));
            assertEquals("Einzeiler", GameManager.strVars.get("Hallo").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testStrVarMultipleWords() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testStrVarMultipleWords");
            player.play();
            assertEquals(true, GameManager.strVars.containsKey("Hallo"));
            assertEquals("Das ist doch toll", GameManager.strVars.get("Hallo").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumVarFalseName() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumVarFalseName");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumVarDoubleName() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumVarDoubleName");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            GameManager.clear();
        }
    }
}
