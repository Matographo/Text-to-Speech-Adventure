package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerActionTest extends OpCodePlayerTesterClass {



// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Action/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testAction() {
        Player player = new Player(PATH + "testAction");
        player.play();
        resetTest();
    }

    @Test
    public void testActionWithActionCall() {
        Player player = new Player(PATH + "testActionWithActionCall");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionCallOtherAction() {
        Player player = new Player(PATH + "testActionCallOtherAction");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseMultipleArgVars() {
        Player player = new Player(PATH + "testActionUseMultipleArgVars");
        player.play();
        assertEquals("Bye", GameManager.strVars.get("Varr").getValue());
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseNumArg() {
        Player player = new Player(PATH + "testActionUseNumArg");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseNumVar() {
        Player player = new Player(PATH + "testActionUseNumVar");
        player.play();
        assertEquals(1, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseStrArg() {
        Player player = new Player(PATH + "testActionUseStrArg");
        player.play();
        assertEquals("Bye", GameManager.strVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testActionUseStrVar() {
        Player player = new Player(PATH + "testActionUseStrVar");
        player.play();
        assertEquals("Bye", GameManager.strVars.get("Varr").getValue());
        resetTest();
    }

    @Test
    public void testActionWithNumArg() {
        Player player = new Player(PATH + "testActionWithNumArg");
        player.play();
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
