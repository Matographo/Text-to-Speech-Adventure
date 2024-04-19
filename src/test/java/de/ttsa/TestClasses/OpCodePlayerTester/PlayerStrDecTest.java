package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.ttsa.Logic.Player.GameManager;
import de.ttsa.Logic.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerStrDecTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "StrDec/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testStrDec() {
        Player player = new Player(PATH + "testStrDec");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Var"));
        assertEquals("all", GameManager.strVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testStrDecWithOtherStrVar() {
        Player player = new Player(PATH + "testStrDecWithOtherStrVar");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Var"));
        assertEquals("all", GameManager.strVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testStrDecMultipleStringsAndVar() {
        Player player = new Player(PATH + "testStrDecMultipleStringsAndVar");
        player.play();
        assertEquals(true, GameManager.strVars.containsKey("Var"));
        assertEquals("Hello all", GameManager.strVars.get("Var").getValue());
        resetTest();
    }


// ------------------------- Fail Tests -------------------------



}
