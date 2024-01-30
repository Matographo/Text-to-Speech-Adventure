package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;

public class PlayerSaveFile {
    
    private final String TEST_FILE_PATH = System.getProperty("user.dir") + "/src/test/java/de/ttsa/TestFiles/OpcodeTests/GameSaver/";

    @Test
    public void testSaveSimpleGame() throws IOException {
        Player player = new Player(TEST_FILE_PATH + "testSaveSimpleGame");
        GameManager.savePath = TEST_FILE_PATH + "testSaveSimpleGame.save";
        player.play();
        assertEquals(5, getLines(TEST_FILE_PATH + "testSaveSimpleGame.save"));

        
    }

    private int getLines(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
}
