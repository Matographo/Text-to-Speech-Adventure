package de.ttsa.FeatureTest.NumInit.TestClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerNumInitTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerNumInitTest() {
        super("NumInit");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testNumDec() {
        Player player = new Player(PATH + "testNumDec.ta");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(10, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecWithOtherNum() {
        int expected = 10;
        Player player = new Player(PATH + "testNumDecWithOtherNum.ta");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecNegativeNumber() {
        int expected = -1;
        Player player = new Player(PATH + "testNumDecNegativeNumber.ta");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcNegativeNumber() {
        int expected = -15;
        Player player = new Player(PATH + "testNumDecCalcNegativeNumber.ta");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcNumberAndVar() {
        int expected = 10;
        Player player = new Player(PATH + "testNumDecCalcNumberAndVar.ta");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcTwoNumbers() {
        int expected = 10;
        Player player = new Player(PATH + "testNumDecCalcTwoNumbers.ta");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }

    @Test
    public void testNumDecCalcWithBreckeds() {
        int expected = 50;
        Player player = new Player(PATH + "testNumDecCalcWithBreckeds.ta");
        player.play();
        assertEquals(true, GameManager.numVars.containsKey("Zahl"));
        assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        resetTest();
    }



// ------------------------- Fail Tests -------------------------



    @Test
    public void testNumDecCalcWithDoublePlus() {
        try {
            Player player = new Player(PATH + "testNumDecCalcWithDoublePlus.ta");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }

    @Test
    public void testNumDecWithString() {
        try {
            Player player = new Player(PATH + "testNumDecWithString.ta");
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
            Player player = new Player(PATH + "testNumDecWithStrVar.ta");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }



}
