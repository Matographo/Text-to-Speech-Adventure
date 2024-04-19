package de.ttsa.Logic.Player.Scriptables;

import java.util.Scanner;

import de.ttsa.Logic.Player.GameManager;

public class Input implements Scriptable {
    

// ---------------------------------------------- Attributes -------------------------------------------------- //



    private static Scanner scanner = new Scanner(System.in);



// ---------------------------------------------- Methods ----------------------------------------------------- //



    @Override
    public boolean run() {
        try {
            if(GameManager.isTerminalGame) {
                GameManager.input = scanner.nextLine();
            }
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    
}
