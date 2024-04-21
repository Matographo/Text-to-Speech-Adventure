package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerStrVarTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "StrVar/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testStrVarOneWord() {
        Player player = new Player(PATH + "testStrVarOneWord");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Hallo"));
        assertEquals("Einzeiler", GameManager.strVars.get("Hallo").getValue());
        resetTest();
    }

    @Test
    public void testStrVarMultipleWords() {
        Player player = new Player(PATH + "testStrVarMultipleWords");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Hallo"));
        assertEquals("Das ist doch toll", GameManager.strVars.get("Hallo").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------


@Test
    public void testNumVarFalseName() {
        try {
            Player player = new Player(PATH + "testNumVarFalseName");
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
            Player player = new Player(PATH + "testNumVarDoubleName");
            player.play();
            fail();
        } catch (Exception e) {
        } finally {
            resetTest();
        }
    }



}
