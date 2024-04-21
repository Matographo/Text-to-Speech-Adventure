package de.ttsa.Logic.Features.RoomJumper;

import de.ttsa.Interfaces.Scriptable;
import de.ttsa.Logic.Player.PlayerLogic.GameManager;

public class RoomJumper implements Scriptable {
    

// ---------------------------------------------- Attributes -------------------------------------------------- //



    private String roomName;



// ---------------------------------------------- Constructor ------------------------------------------------- //


    /**
     * Jump to a room
     * @param roomName the name of the room
     */
    public RoomJumper(String roomName) {
        this.roomName = roomName;
    }



// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        if(!GameManager.rooms.containsKey(roomName)) return true;
        
        GameManager.nextRoom = roomName;
        return false;
    }



}
