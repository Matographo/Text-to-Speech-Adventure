package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerIfTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/If/";

    @Test
    public void testIf() {
        final int expected = 1;
        try {
            
            Player player = new Player(TEST_FILE_PATH + "testIf");
            player.play();
            assertEquals(expected, GameManager.numVars.get("Hi").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testIfWithTwoVars() {
        final int expected = 1;
        try {
            
            Player player = new Player(TEST_FILE_PATH + "testIfWithTwoVars");
            player.play();
            assertEquals(expected, GameManager.numVars.get("Var").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testIfWithVar() {
        final int expected = 1;
        try {
            
            Player player = new Player(TEST_FILE_PATH + "testIfWithVar");
            player.play();
            assertEquals(expected, GameManager.numVars.get("Var").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }
}
