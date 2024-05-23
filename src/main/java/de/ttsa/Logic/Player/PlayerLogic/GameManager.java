package de.ttsa.Logic.Player.PlayerLogic;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import de.ttsa.Logic.Features.Action.Action;
import de.ttsa.Logic.Features.Room.Room;
import de.ttsa.Logic.Features.Set.Set;
import de.ttsa.Logic.Player.Datatypes.INT;
import de.ttsa.Logic.Player.Datatypes.STRING;
import de.ttsa.Logic.Player.Functions.PlayerFunctions.GameSaver;


public class GameManager {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    public static String savePath;

    public static File gameFile;

    public static HashMap<String, Room> rooms     = new HashMap<>();
    public static HashMap<String, INT> numVars    = new HashMap<>();
    public static HashMap<String, STRING> strVars = new HashMap<>();
    public static HashMap<String, Set> sets       = new HashMap<>();
    public static HashMap<String, Action> actions = new HashMap<>();
    public static HashMap<String, String> music   = new HashMap<>();

    public static String currentRoom;
    public static String nextRoom;
    public static String input;

    public static ArrayList<String> output = new ArrayList<>();

    public static boolean running;
    public static boolean isTerminalGame = true;
    public static boolean loopBreak = false;
    public static boolean isMakedInput = false;



// ---------------------------------------------- Methods ----------------------------------------------------- //


    /**
     * Add a room to the game
     * @param name the name of the room
     * @param room the room that should be added
     */
    public static void addRoom(String name, Room room) {
        rooms.put(name, room);
    }

    /**
     * Get the next room
     * @return the next room
     */
    public static Room getNextRoom() {
        Room room = rooms.get(nextRoom);
        currentRoom = nextRoom;
        nextRoom = null;
        return room;
    }

    /**
     * Clear the game data and reset the game
     */
    public static void clear() {
        rooms.clear();
        numVars.clear();
        strVars.clear();
        sets.clear();
        actions.clear();
        currentRoom = null;
        nextRoom = null;
    }

    /**
     * Save the game
     */
    public static void saveGame() {
        new GameSaver(savePath);
        GameSaver.saveGame();
    }

    /**
     * Load the game
     */
    public static void loadGame() {
        new GameSaver(savePath);
        GameSaver.loadGame();
    }

    /**
     * Exit the game
     * @param save if the game should be saved
     */
    public static void exitGame(boolean save) {
        if(save) {
            saveGame();
        }
        running = false;
    }


    
}
