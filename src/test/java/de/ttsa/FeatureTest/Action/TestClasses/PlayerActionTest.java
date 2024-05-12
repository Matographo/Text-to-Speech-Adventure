package de.ttsa.FeatureTest.Action.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerActionTest extends OpCodePlayerTesterClass {



// ------------------------------ PATHS ------------------------------



    public PlayerActionTest() {
        super("Action");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testAction() {
        Player player = new Player(PATH + "testAction.ta");
        player.play();
        resetTest();
    }

    @Test
    public void testActionWithActionCall() {
        Player player = new Player(PATH + "testActionWithActionCall.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionCallOtherAction() {
        Player player = new Player(PATH + "testActionCallOtherAction.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseMultipleArgVars() {
        Player player = new Player(PATH + "testActionUseMultipleArgVars.ta");
        player.play();
        assertEquals("Bye", GameManager.strVars.get("Varr").getValue());
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseNumArg() {
        Player player = new Player(PATH + "testActionUseNumArg.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseNumVar() {
        Player player = new Player(PATH + "testActionUseNumVar.ta");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseStrArg() {
        Player player = new Player(PATH + "testActionUseStrArg.ta");
        player.play();
        assertEquals("Bye", GameManager.strVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseStrVar() {
        Player player = new Player(PATH + "testActionUseStrVar.ta");
        player.play();
        assertEquals("Bye", GameManager.strVars.get("Varr").getValue());
        resetTest();
    }

    @Test
    public void testActionWithNumArg() {
        Player player = new Player(PATH + "testActionWithNumArg.ta");
        player.play();
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
