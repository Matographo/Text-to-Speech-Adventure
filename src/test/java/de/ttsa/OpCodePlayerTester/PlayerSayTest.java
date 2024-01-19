package de.ttsa.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.GetOutput;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerSayTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/OpCodePlayerTester/TestFiles/";

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
        }
    }

    @Test
    public void testSayMultipleSaysFixStrings() {
        String expected = "Hallo\ndu\ntolle\nWelt";
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
        }
    }

}
