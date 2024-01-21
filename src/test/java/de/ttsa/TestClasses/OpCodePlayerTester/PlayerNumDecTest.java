package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerNumDecTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/NumDec/";

    @Test
    public void testNumDec() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDec");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(10, GameManager.numVars.get("Zahl").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecWithString() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecWithString");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(10, GameManager.numVars.get("Zahl").getValue());
            fail();
        } catch (Exception e) {
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecWithStrVar() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecWithStrVar");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecWithOtherNum() {
        int expected = 10;
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecWithOtherNum");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecNegativeNumber() {
        int expected = -1;
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecNegativeNumber");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecCalcNegativeNumber() {
        int expected = -15;
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecCalcNegativeNumber");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecCalcNumberAndVar() {
        int expected = 10;
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecCalcNumberAndVar");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecCalcTwoNumbers() {
        int expected = 10;
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecCalcTwoNumbers");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecCalcWithBreckeds() {
        int expected = 50;
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecCalcWithBreckeds");
            player.play();
            assertEquals(true, GameManager.numVars.containsKey("Zahl"));
            assertEquals(expected, GameManager.numVars.get("Zahl").getValue());
        } catch (Exception e) {
            fail();
        } finally {
            GameManager.clear();
        }
    }

    @Test
    public void testNumDecCalcWithDoublePlus() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testNumDecCalcWithDoublePlus");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            GameManager.clear();
        }
    }


}
