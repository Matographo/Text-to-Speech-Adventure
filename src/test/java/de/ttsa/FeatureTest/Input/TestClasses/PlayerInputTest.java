package de.ttsa.FeatureTest.Input.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerInputTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerInputTest() {
        super("Input");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testInputEQStr() {
        Player player = new Player(PATH + "testInputEQStr.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputEQStrVar() {
        Player player = new Player(PATH + "testInputEQStrVar.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputInOrderDoubleOffOrder() {
        Player player = new Player(PATH + "testInputInOrderDoubleOffOrder.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputInOrderOffOrderStr() {
        Player player = new Player(PATH + "testInputInOrderOffOrderStr.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputOffOrderStr() {
        Player player = new Player(PATH + "testInputOffOrderStr.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testInputOffOrderStrAndStrVar() {
        Player player = new Player(PATH + "testInputOffOrderStrAndStrVar.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------




}
