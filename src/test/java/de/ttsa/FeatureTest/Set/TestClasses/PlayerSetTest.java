package de.ttsa.FeatureTest.Set.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerSetTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerSetTest() {
        super("Set");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSetJustSet() {
        Player player = new Player(PATH + "testSetJustSet.ta");
        player.play();
        assertEquals(3, GameManager.sets.get("Attack").getStr().size());
        resetTest();
    }

    @Test
    public void testSetWithRoom() {
        Player player = new Player(PATH + "testSetWithRoom.ta");
        player.play();
        assertEquals(3, GameManager.sets.get("Attack").getStr().size());
        resetTest();
    }

    @Test
    public void testSetWithVariable() {
        Player player = new Player(PATH + "testSetWithVariable.ta");
        player.play();
        assertEquals(1, GameManager.sets.get("Attack").getStr().size());
        assertEquals(1, GameManager.sets.get("Attack").getVar().size());
        resetTest();
    }

    @Test
    public void testSetInIf() {
        Player player = new Player(PATH + "testSetInIf.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Varr").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
