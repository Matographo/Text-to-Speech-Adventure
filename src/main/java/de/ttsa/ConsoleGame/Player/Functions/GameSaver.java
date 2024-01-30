package de.ttsa.ConsoleGame.Player.Functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.INT;
import de.ttsa.ConsoleGame.Player.Datatypes.STRING;

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

        writer.write("::VARS::" + GameManager.numVars.size() + "\n");
        writer = saveHashMap(writer, GameManager.numVars);

        writer.write("::STRINGS::" + GameManager.strVars.size() + "\n");
        writer = saveHashMap(writer, GameManager.strVars);

        writer.write("::CURRENTROOM::" + GameManager.currentRoom + "\n");
        writer.close();
    }

    private BufferedWriter saveHashMap(BufferedWriter writer, HashMap<String, ?> map) throws IOException {
        HashSet<String> keys = new HashSet<>(map.keySet());
        for (String key : keys) {
            writer.write(key + "::" + map.get(key).toString() + "\n");
        }
        return writer;
    }

    public static void loadGame() {
        try {
            File file = new File(savePath);
            if(!file.exists())   throw new RuntimeException("File not found");
            if(!file.isFile())   throw new RuntimeException("File is not a file");
            if(!file.canRead()) throw new RuntimeException("File is not readable");
            new GameSaver().load();
        } catch (IOException e) {
            throw new RuntimeException("Error while loading game");
        }
    }

    private void load() throws IOException {
        File file = new File(savePath);
        BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
        ArrayList<String> lines = new ArrayList<>();
        String line = "";
        while((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        loadData(lines);
    }

    private void loadData(ArrayList<String> lines) {
        String line;
        int counter = 0;
        char type = ' ';
        for(int i = 0; i < lines.size(); i++) {
            line = lines.get(i);
            if(line.startsWith("::")) {
                line = line.substring(2);
                if(line.startsWith("VARS::") && counter == 0) {
                    counter = Integer.parseInt(line.substring(line.indexOf("::") + 2));
                    type = 'N';
                    continue;
                } else if(line.startsWith("STRINGS::") && counter == 0) {
                    counter = Integer.parseInt(line.substring(line.indexOf("::") + 2));
                    type = 'S';
                    continue;
                } else if(line.startsWith("CURRENTROOM::") && counter == 0) {
                    GameManager.currentRoom = line.substring(line.indexOf("::") + 2);
                    type = 'R';
                    continue;
                }
            } else if(counter > 0) {
                if(type == 'N') {
                    String[] parts = line.split("::");
                    GameManager.numVars.put(parts[0], new INT(Integer.parseInt(parts[1])));
                } else if(type == 'S') {
                    String[] parts = line.split("::");
                    GameManager.strVars.put(parts[0], new STRING(parts[1]));
                } else if(type == 'R') {
                    GameManager.nextRoom = line;
                }

            } 
        }
    }
}
