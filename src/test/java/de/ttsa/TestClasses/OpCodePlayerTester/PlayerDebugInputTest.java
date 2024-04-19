package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Player.GameManager;
import de.ttsa.Logic.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerDebugInputTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "DebugInput/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testDebugInput() {
        Player player = new Player(PATH + "testDebugInput");
        player.play();
        assertEquals("input", GameManager.input);
        resetTest();
    }

    @Test
    public void testDebugInputWithStrVar() {
        Player player = new Player(PATH + "testDebugInputWithStrVar");
        player.play();
        assertEquals("input", GameManager.input);
        resetTest();
    }

    @Test
    public void testDebugInputWithStrVarAndString() {
        Player player = new Player(PATH + "testDebugInputWithStrVarAndString");
        player.play();
        assertEquals("Hallo input", GameManager.input);
        resetTest();
    }

// ------------------------- Fail Tests -------------------------




}
