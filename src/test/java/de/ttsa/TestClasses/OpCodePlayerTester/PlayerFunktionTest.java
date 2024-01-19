package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.fail;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.Player;

public class PlayerFunktionTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/";

    @Test
    public void testEmptyFile() {
        try {
            Player player = new Player(TEST_FILE_PATH + "testEmptyFile");
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testNoneExistingFile() {
        try {
        Player test = new Player(TEST_FILE_PATH + "jkflasodijasdfadsfjajiewofewfaksdknawifowejfwf");
        fail();
        } catch (Exception e) {
        }
    }
}
