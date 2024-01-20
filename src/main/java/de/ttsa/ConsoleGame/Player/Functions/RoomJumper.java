package de.ttsa.ConsoleGame.Player.Functions;

import de.ttsa.ConsoleGame.Player.GameManager;
import de.ttsa.ConsoleGame.Player.Datatypes.Scriptable;

public class RoomJumper implements Scriptable {
    
    private String roomName;

    public RoomJumper(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public boolean run() {
        if(!GameManager.rooms.containsKey(roomName)) return false;
        GameManager.nextRoom = roomName;
        return true;
    }


}
