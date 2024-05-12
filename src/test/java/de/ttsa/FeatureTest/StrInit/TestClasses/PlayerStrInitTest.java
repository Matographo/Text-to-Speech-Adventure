package de.ttsa.FeatureTest.StrInit.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerStrInitTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerStrInitTest() {
        super("StrInit");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testStrDec() {
        Player player = new Player(PATH + "testStrDec.ta");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Var"));
        assertEquals("all", GameManager.strVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testStrDecWithOtherStrVar() {
        Player player = new Player(PATH + "testStrDecWithOtherStrVar.ta");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Var"));
        assertEquals("all", GameManager.strVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testStrDecMultipleStringsAndVar() {
        Player player = new Player(PATH + "testStrDecMultipleStringsAndVar.ta");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Var"));
        assertEquals("Hello all", GameManager.strVars.get("Var").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
