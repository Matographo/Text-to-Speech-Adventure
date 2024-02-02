package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerIfTest extends OpCodePlayerTesterClass {
    
    private final String PATH = TEST_FILE_PATH + "If/";

    @Test
    public void testIf() {
        final int expected = 1;
        Player player = new Player(PATH + "testIf");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Hi").getValue());
        resetTest();
    }

    @Test
    public void testIfWithTwoVars() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithTwoVars");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithVar() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithVar");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfLeftGERight() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfLeftGERight");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfLeftLowerRight() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfLeftLowerRight");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfLeftNERight() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfLeftNERight");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithCalc() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithCalc");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithCalcVar() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithCalcVar");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithElse() {
        final int expected = 2;
        Player player = new Player(PATH + "testIfWithElse");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithElseIf() {
        final int expected = 2;
        Player player = new Player(PATH + "testIfWithElseIf");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithStrVar() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithStrVar");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testIfWithStrVarEQStrVar() {
        final int expected = 1;
        Player player = new Player(PATH + "testIfWithStrVarEQStrVar");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        resetTest();
    }
}
