package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerSaveLoadExitTest {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/SaveLoadExit/";

    @Test
    public void testSaveSimpleGame() throws IOException {
        Player player = new Player(TEST_FILE_PATH + "testSaveSimpleGame");
        GameManager.savePath = TEST_FILE_PATH + "testSaveSimpleGame.save";
        player.play();
        assertEquals(5, getLines(TEST_FILE_PATH + "testSaveSimpleGame.save"));
    }

    @Test
    public void testLoadSimpleGame() throws IOException {
        Player player = new Player(TEST_FILE_PATH + "testLoadSimpleGame");
        GameManager.savePath = TEST_FILE_PATH + "testLoadSimpleGame.save";
        player.play();
        assertEquals(20, GameManager.numVars.get("Var").getValue());
    }

// konnte nicht wirklich getestet werden, da es nach dem exit der test selbst beendet wird

    // @Test
    // public void testExitSimpleGameWithoutSave() throws IOException {
    //     Player player = new Player(TEST_FILE_PATH + "testExitSimpleGameWithoutSave");
    //     GameManager.savePath = TEST_FILE_PATH + "testExitSimpleGameWithoutSave.save";
    //     player.play();
    //     assertEquals(0, getLines(TEST_FILE_PATH + "testExitSimpleGameWithoutSave.save"));
    // }

    // @Test
    // public void testExitSimpleGameWithSave() throws IOException {
    //     Player player = new Player(TEST_FILE_PATH + "testExitSimpleGameWithSave");
    //     GameManager.savePath = TEST_FILE_PATH + "testExitSimpleGameWithSave.save";
    //     player.play();
    //     assertEquals(5, getLines(TEST_FILE_PATH + "testExitSimpleGameWithSave.save"));
    // }


    private int getLines(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
}
