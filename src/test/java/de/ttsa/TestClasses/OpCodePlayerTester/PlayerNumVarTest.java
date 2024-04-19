package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.Logic.Player.GameManager;
import de.ttsa.Logic.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerNumVarTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "NumVar/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testNumVar() {
        Player player = new Player(PATH + "testNumVar");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Hallo"));
        assertEquals(5, GameManager.numVars.get("Hallo").getValue());
        resetTest();
    }



// ------------------------- Fail Tests -------------------------



    @Test
    public void testNumVarFalseSyntax() {
        try {
            Player player = new Player(PATH + "testNumVarFalseSyntax");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }

    @Test
    public void testNumVarInvalideName() {
        try {
            Player player = new Player(PATH + "testNumVarInvalideName");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }



}
