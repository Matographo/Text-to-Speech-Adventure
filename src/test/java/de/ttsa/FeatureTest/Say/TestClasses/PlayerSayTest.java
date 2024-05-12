package de.ttsa.FeatureTest.Say.TestClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.HelpClasses.GetOutput;
import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerSayTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerSayTest() {
        super("Say");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSayFixString() {
        String expected = "Hallo Welt!";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testSayFixString.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }

    @Test
    public void testSayMultipleFixStringsAtOnce() {
        String expected = "Hallo Weltchen!";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testSayMultipleFixStringsAtOnce.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }

    @Test
    public void testSayMultipleSaysFixStrings() {
        String expected = "Hello\nWorld\nThis is cool";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testSayMultipleSaysFixStrings.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }

    @Test
    public void testSayNumVar() {
        String expected = "5";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testSayNumVar.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }

    @Test
    public void testSayStrVar() {
        String expected = "Hallo Welt!";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testSayStrVar.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }

    @Test
    public void testSayFixStringAndStrVar() {
        String expected = "Hallo Welt!";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testSayFixStringAndStrVar.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }

    @Test
    public void testSayNumVarAndFixString() {
        String expected = "5Hallo";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testSayNumVarAndFixString.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }

    @Test
    public void testSayStrVarAndNumVar() {
        String expected = "Hallo 5";
        GetOutput output = new GetOutput();
        Player player = new Player(PATH + "testSayStrVarAndNumVar.ta");
        output.init();
        player.play();
        assertEquals(expected, output.getTerminalOutput());
        output.reinit();
        resetTest();
    }


// ------------------------- Fail Tests -------------------------


    @Test
    public void testSayNonExistingVar() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(PATH + "testSayNonExistingVar.ta");
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
    public void testSayFixNumber() {
        GetOutput output = new GetOutput();
        try {
            Player player = new Player(PATH + "testSayFixNumber.ta");
            output.init();
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            output.reinit();
            resetTest();
        }
    }

}
