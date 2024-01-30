package de.ttsa.ConsoleGame.Player;

import java.util.HashMap;

import de.ttsa.ConsoleGame.Player.Datatypes.INT;
import de.ttsa.ConsoleGame.Player.Datatypes.STRING;
import de.ttsa.ConsoleGame.Player.Functions.GameSaver;
import de.ttsa.ConsoleGame.Player.Structures.Room;

public class GameManager {

    public static String savePath;

    public static HashMap<String, Room> rooms = new HashMap<>();
    public static HashMap<String, INT> numVars = new HashMap<>();
    public static HashMap<String, STRING> strVars = new HashMap<>();

    public static String currentRoom;
    public static String nextRoom;
    public static String input;


    public static void addRoom(String name, Room room) {
        rooms.put(name, room);
    }

    public static Room getNextRoom() {
        Room room = rooms.get(nextRoom);
        currentRoom = nextRoom;
        nextRoom = null;
        return room;
    }

    public static void clear() {
        rooms.clear();
        numVars.clear();
        strVars.clear();
        nextRoom = null;
    }

    public static void saveGame() {
        new GameSaver(savePath);
        GameSaver.saveGame();
    }

    public static void loadGame() {
        new GameSaver(savePath);
        GameSaver.loadGame();
    }

}
