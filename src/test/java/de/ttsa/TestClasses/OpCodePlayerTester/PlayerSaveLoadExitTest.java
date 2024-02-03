package de.ttsa.TestClasses.OpCodePlayerTester;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Player;
import de.ttsa.TestClasses.OpCodePlayerTesterClass;

public class PlayerSaveLoadExitTest extends OpCodePlayerTesterClass {
    


// ------------------------------ PATHS ------------------------------



    private final String PATH = TEST_FILE_PATH + "SaveLoadExit/";



// ------------------------- Accepted Tests -------------------------



    @Test
    public void testSaveSimpleGame() throws IOException {
        Player player = new Player(PATH + "testSaveSimpleGame");
        GameManager.savePath = PATH + "testSaveSimpleGame.save";
        player.play();
        assertEquals(5, getLines(PATH + "testSaveSimpleGame.save"));
        resetTest();
    }

    @Test
    public void testLoadSimpleGame() throws IOException {
        Player player = new Player(PATH + "testLoadSimpleGame");
        GameManager.savePath = PATH + "testLoadSimpleGame.save";
        player.play();
        assertEquals(20, GameManager.numVars.get("Var").getValue());
        resetTest();
    }

    @Test
    public void testExitSimpleGameWithoutSave() throws IOException {
        Player player = new Player(PATH + "testExitSimpleGameWithoutSave");
        GameManager.savePath = PATH + "testExitSimpleGameWithoutSave.save";
        player.play();
        assertEquals(false, GameManager.running);
        resetTest();
    }

    @Test
    public void testExitSimpleGameWithSave() throws IOException {
        Player player = new Player(PATH + "testExitSimpleGameWithSave");
        GameManager.savePath = PATH + "testExitSimpleGameWithSave.save";
        player.play();
        assertEquals(3, getLines(PATH + "testExitSimpleGameWithSave.save"));
        resetTest();
    }


    
    
// ---------------------------- Fail Tests -----------------------------
    
    
    



// ------------------------------ HELPERS ------------------------------



    private int getLines(String path) throws IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }



}
