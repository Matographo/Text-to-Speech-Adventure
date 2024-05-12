package de.ttsa.Logic.Compiler.CompilerSteps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import de.ttsa.Tools.ZipManager;

public class GameBuilder {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    ArrayList<String> gameContent;
    String gamePath = "/home/leodora/Documents/Dev/Java/Text-to-Speech-Adventure/Code/";



// ---------------------------------------------- Constructor -------------------------------------------------- //



    public GameBuilder(ArrayList<String> gameContent) {
        this.gameContent = gameContent;
    }



// ---------------------------------------------- Methods -------------------------------------------------- //



    public boolean build() {
        File gameFolder = new File(gamePath + "LittleGamee");
        if(!gameFolder.exists()) {
            gameFolder.mkdir();
        } else {
            System.out.println("Game folder already exists. You want to overwrite it? (y/n)");
            switch (new Scanner(System.in).nextLine().toLowerCase()) {
                case "y":
                    gameFolder.delete();
                    gameFolder.mkdir();
                    break;
                default:
                    return false;
            }
        }
        File gameFile = new File(gamePath + "LittleGamee/game.ttsa");
        if(gameFile.exists()) {
            gameFile.delete();
        }
        try {
            gameFile.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        // Write game content to file
        try {
            FileWriter writer = new FileWriter(gameFile);
            for (String line : gameContent) {
                writer.write(line + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        File zipFile = ZipManager.zip(gameFile.getParentFile().getAbsolutePath(), gameFile.getParentFile().getParentFile().getParentFile().getAbsolutePath() + "/Games", "LittleGameee");
        zipFile.renameTo(new File(zipFile.getParentFile().getAbsolutePath() + "/LittleGame.ttsa"));
        return deleteAll(gameFolder);
    }

    private boolean deleteAll(File file) {
        if(file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                deleteAll(subFile);
            }
        }
        return file.delete();
    }
    

    
}
