package de.ttsa.ConsoleGame.Player.Scriptables;

import java.util.Scanner;

import de.ttsa.ConsoleGame.Player.GameManager;

public class Input implements Scriptable {
    
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public boolean run() {
        try {
            GameManager.input = scanner.nextLine();
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}
