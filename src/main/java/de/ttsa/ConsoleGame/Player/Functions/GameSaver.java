package de.ttsa.ConsoleGame.Player.Functions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import de.ttsa.ConsoleGame.Player.GameManager;

public class GameSaver {
    
    private static String savePath;

    private GameSaver() {
    }

    public GameSaver(String path) {
        savePath = path;
    }

    public static void saveGame() {
        try {
            File file = new File(savePath);
            if(!file.exists())   throw new RuntimeException("File not found");
            if(!file.isFile())   throw new RuntimeException("File is not a file");
            if(!file.canWrite()) throw new RuntimeException("File is not writable");
            new GameSaver().save();
        } catch (IOException e) {
            throw new RuntimeException("Error while saving game");
        }
    }

    private void save() throws IOException {
        File file = new File(savePath);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write("VARS::" + GameManager.numVars.size() + "\n");
        writer = saveHashMap(writer, GameManager.numVars);

        writer.write("STRINGS::" + GameManager.strVars.size() + "\n");
        writer = saveHashMap(writer, GameManager.strVars);

        writer.write("CURRENTROOM::" + GameManager.currentRoom + "\n");
        writer.close();
    }

    private BufferedWriter saveHashMap(BufferedWriter writer, HashMap<String, ?> map) throws IOException {
        HashSet<String> keys = new HashSet<>(map.keySet());
        for (String key : keys) {
            writer.write(key + "::" + map.get(key).toString() + "\n");
        }
        return writer;
    }
}
