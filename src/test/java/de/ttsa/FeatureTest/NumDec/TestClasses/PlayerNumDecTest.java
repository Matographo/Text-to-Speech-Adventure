package de.ttsa.FeatureTest.NumDec.TestClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerNumDecTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerNumDecTest() {
        super("NumDec");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testNumVar() {
        Player player = new Player(PATH + "testNumVar.ta");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Hallo"));
        assertEquals(5, GameManager.numVars.get("Hallo").getValue());
        resetTest();
    }



// ------------------------- Fail Tests -------------------------



    @Test
    public void testNumVarFalseSyntax() {
        try {
            Player player = new Player(PATH + "testNumVarFalseSyntax.ta");
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
            Player player = new Player(PATH + "testNumVarInvalideName.ta");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }



}
