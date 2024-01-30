package de.ttsa.ConsoleGame.Player.Scriptables;

import de.ttsa.ConsoleGame.Player.GameManager;

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
