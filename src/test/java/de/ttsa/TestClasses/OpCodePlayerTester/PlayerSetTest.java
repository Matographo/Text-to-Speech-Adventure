package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerSetTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Set/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSetJustSet() {
        Player player = new Player(PATH + "testSetJustSet");
        player.play();
        assertEquals(3, GameManager.sets.get("Attack").getStr().size());
        resetTest();
    }

    @Test
    public void testSetWithRoom() {
        Player player = new Player(PATH + "testSetWithRoom");
        player.play();
        assertEquals(3, GameManager.sets.get("Attack").getStr().size());
        resetTest();
    }

    @Test
    public void testSetWithVariable() {
        Player player = new Player(PATH + "testSetWithVariable");
        player.play();
        assertEquals(1, GameManager.sets.get("Attack").getStr().size());
        assertEquals(1, GameManager.sets.get("Attack").getVar().size());
        resetTest();
    }

    @Test
    public void testSetInIf() {
        Player player = new Player(PATH + "testSetInIf");
        player.play();
        assertEquals(1, GameManager.numVars.get("Varr").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
