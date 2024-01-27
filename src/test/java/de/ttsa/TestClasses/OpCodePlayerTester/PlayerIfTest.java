package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerIfTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/If/";

    @Test
    public void testIf() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIf");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Hi").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfWithTwoVars() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfWithTwoVars");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfWithVar() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfWithVar");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfLeftGERight() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfLeftGERight");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfLeftLowerRight() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfLeftLowerRight");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfLeftNERight() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfLeftNERight");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfWithCalc() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfWithCalc");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfWithCalcVar() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfWithCalcVar");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfWithElse() {
        final int expected = 2;
        Player player = new Player(TEST_FILE_PATH + "testIfWithElse");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfWithElseIf() {
        final int expected = 2;
        Player player = new Player(TEST_FILE_PATH + "testIfWithElseIf");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfWithStrVar() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfWithStrVar");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }

    @Test
    public void testIfWithStrVarEQStrVar() {
        final int expected = 1;
        Player player = new Player(TEST_FILE_PATH + "testIfWithStrVarEQStrVar");
        player.play();
        assertEquals(expected, GameManager.numVars.get("Var").getValue());
        GameManager.clear();
    }
}
