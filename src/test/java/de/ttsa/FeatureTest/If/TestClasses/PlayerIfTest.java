package de.ttsa.FeatureTest.If.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerIfTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerIfTest() {
        super("If");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testIf() {
        final int expected = 1;
        Player player = new Player(PATH + "testIf.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Hi").getValue());
        resetTest();
    }

    @Test
    public void testIfWithTwoVars() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithTwoVars.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithVar() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithVar.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfLeftGERight() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfLeftGERight.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfLeftLowerRight() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfLeftLowerRight.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfLeftNERight() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfLeftNERight.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithCalc() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithCalc.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithCalcVar() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithCalcVar.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithElse() {
        final int expected = 2;
        Player player = new Player(PATH + "testIfWithElse.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithElseIf() {
        final int expected = 2;
        Player player = new Player(PATH + "testIfWithElseIf.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithStrVar() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithStrVar.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithStrVarEQStrVar() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithStrVarEQStrVar.ta");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfStrEQStr() {
        final String expected = "Hallo";
        Player player = new Player(PATH + "testIfStrEQStr.ta");
        player.play();
        assertEquals(expected, GameManager.strVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfStrNEStr() {
        final String expected = "Hallo";
        Player player = new Player(PATH + "testIfStrNEStr.ta");
        player.play();
        assertEquals(expected, GameManager.strVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfStrVarEQStr() {
        final String expected = "Hallo";
        Player player = new Player(PATH + "testIfStrVarEQStr.ta");
        player.play();
        assertEquals(expected, GameManager.strVars.get("Var").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
