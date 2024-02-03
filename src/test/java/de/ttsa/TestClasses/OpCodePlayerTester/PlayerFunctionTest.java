package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerFunctionTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "Function/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testEmptyFile() {
            new Player(PATH + "testEmptyFile");
    }


// ------------------------- Fail Tests -------------------------



    @Test
    public void testNoneExistingFile() {
        try {
        new Player(PATH + "jkflasodijasdfadsfjajiewofewfaksdknawifowejfwf");
        fail();
        } catch (Exception e) {
        }
    }



}
