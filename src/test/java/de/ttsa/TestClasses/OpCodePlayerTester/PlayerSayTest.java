package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.GetOutput;
import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerSayTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/Say/";

    @Test
    public void testSayFixString() {
        String expected = "Hallo Welt!";
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayFixString");
            output.init();
            player.play();
            assertEquals(expected, output.getTerminalOutput());
        } catch (Exception e) {
            fail();
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayMultipleFixStringsAtOnce() {
        String expected = "Hallo Weltchen!";
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayMultipleFixStringsAtOnce");
            output.init();
            player.play();
            assertEquals(expected, output.getTerminalOutput());
        } catch (Exception e) {
            fail();
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayMultipleSaysFixStrings() {
        String expected = "Hello\nWorld\nThis is cool";
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayMultipleSaysFixStrings");
            output.init();
            player.play();
            assertEquals(expected, output.getTerminalOutput());
        } catch (Exception e) {
            fail();
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayFixNumber() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayFixNumber");
            output.init();
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayNumVar() {
        String expected = "5";
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayNumVar");
            output.init();
            player.play();
            assertEquals(expected, output.getTerminalOutput());
        } catch (Exception e) {
            fail();
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayStrVar() {
        String expected = "Hallo Welt!";
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayStrVar");
            output.init();
            player.play();
            assertEquals(expected, output.getTerminalOutput());
        } catch (Exception e) {
            fail();
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayFixStringAndStrVar() {
        String expected = "Hallo Welt!";
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayFixStringAndStrVar");
            output.init();
            player.play();
            assertEquals(expected, output.getTerminalOutput());
        } catch (Exception e) {
            fail();
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayNonExistingVar() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayNonExistingVar");
            output.init();
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayNumVarAndFixString() {
        String expected = "5Hallo";
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayNumVarAndFixString");
            output.init();
            player.play();
            assertEquals(expected, output.getTerminalOutput());
        } catch (Exception e) {
            fail();
        } finally {
            output.reinit();
            resetTest();
        }
    }

    @Test
    public void testSayStrVarAndNumVar() {
        String expected = "Hallo 5";
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(TEST_FILE_PATH + "testSayStrVarAndNumVar");
            output.init();
            player.play();
            assertEquals(expected, output.getTerminalOutput());
        } catch (Exception e) {
            fail();
        } finally {
            output.reinit();
            resetTest();
        }
    }



    private void resetTest() {
        GameManager.clear();
    }

}
