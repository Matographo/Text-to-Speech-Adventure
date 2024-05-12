package de.ttsa.FunctionTest.TestClasses;

import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.Logic.Player.PlayerLogic.GameManager;
import de.ttsa.Logic.Player.PlayerLogic.Player;

public class PlayerFunctionTest {
    
// ------------------------------ PATHS ------------------------------



private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/FunctionTest/";
protected final String PATH;
private final String TEST_PATH = "/TestFiles/";



// ------------------------------ CONSTRUCTOR ------------------------------



    public PlayerFunctionTest() {
        PATH = TEST_FILE_PATH + TEST_PATH;
    }



// ------------------------------ METHODS ------------------------------



    protected void resetTest() {
        GameManager.clear();
    }


// ------------------------- Accepted Tests -------------------------



    @Test
    public void testEmptyFile() {
            new Player(PATH + "testEmptyFile.ta");
    }


// ------------------------- Fail Tests -------------------------



    @Test
    public void testNoneExistingFile() {
        try {
        new Player(PATH + "jkflasodijasdfadsfjajiewofewfaksdknawifowejfwf.ta");
        fail();
        } catch (Exception e) {
        }
    }



}
