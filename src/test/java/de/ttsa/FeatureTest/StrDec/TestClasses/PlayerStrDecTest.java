package de.ttsa.FeatureTest.StrDec.TestClasses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.HelpClasses.OpCodePlayerTesterClass;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerStrDecTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    public PlayerStrDecTest() {
        super("StrDec");
    }



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testStrVarOneWord() {
        Player player = new Player(PATH + "testStrVarOneWord.ta");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Hallo"));
        assertEquals("Einzeiler", GameManager.strVars.get("Hallo").getValue());
        resetTest();
    }

    @Test
    public void testStrVarMultipleWords() {
        Player player = new Player(PATH + "testStrVarMultipleWords.ta");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Hallo"));
        assertEquals("Das ist doch toll", GameManager.strVars.get("Hallo").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------


@Test
    public void testNumVarFalseName() {
        try {
            Player player = new Player(PATH + "testNumVarFalseName.ta");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }
    
    @Test
    public void testNumVarDoubleName() {
        try {
            Player player = new Player(PATH + "testNumVarDoubleName.ta");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }



}
