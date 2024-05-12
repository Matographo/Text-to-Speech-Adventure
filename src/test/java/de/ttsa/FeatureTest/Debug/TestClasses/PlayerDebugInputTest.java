package de.ttsa.FeatureTest.Debug.TestClasses;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerDebugInputTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerDebugInputTest() {
        super("Debug");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testDebugInput() {
        Player player = new Player(PATH + "testDebugInput.ta");
        player.play();
        assertEquals("input", GameManager.input);
        resetTest();
    }

    @Test
    public void testDebugInputWithStrVar() {
        Player player = new Player(PATH + "testDebugInputWithStrVar.ta");
        player.play();
        assertEquals("input", GameManager.input);
        resetTest();
    }

    @Test
    public void testDebugInputWithStrVarAndString() {
        Player player = new Player(PATH + "testDebugInputWithStrVarAndString.ta");
        player.play();
        assertEquals("Hallo input", GameManager.input);
        resetTest();
    }

// ------------------------- Fail Tests -------------------------




}
