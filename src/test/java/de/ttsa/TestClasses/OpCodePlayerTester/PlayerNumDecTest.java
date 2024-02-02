package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerNumDecTest extends OpCodePlayerTesterClass {
    
    private final String PATH = TEST_FILE_PATH + "NumDec/";

    @Test
    public void testNumDec() {
        Player player = new Player(PATH + "testNumDec");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(10, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecWithString() {
        try {
            Player player = new Player(PATH + "testNumDecWithString");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(10, GameManager.numVars.get("Zahl").getValue());
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecWithStrVar() {
        try {
            Player player = new Player(PATH + "testNumDecWithStrVar");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecWithOtherNum() {
        int expected = 10;
        Player player = new Player(PATH + "testNumDecWithOtherNum");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecNegativeNumber() {
        int expected = -1;
        Player player = new Player(PATH + "testNumDecNegativeNumber");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcNegativeNumber() {
        int expected = -15;
        Player player = new Player(PATH + "testNumDecCalcNegativeNumber");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcNumberAndVar() {
        int expected = 10;
        Player player = new Player(PATH + "testNumDecCalcNumberAndVar");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcTwoNumbers() {
        int expected = 10;
        Player player = new Player(PATH + "testNumDecCalcTwoNumbers");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcWithBreckeds() {
        int expected = 50;
        Player player = new Player(PATH + "testNumDecCalcWithBreckeds");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcWithDoublePlus() {
        try {
            Player player = new Player(PATH + "testNumDecCalcWithDoublePlus");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }


}
