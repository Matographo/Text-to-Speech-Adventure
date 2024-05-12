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
    String fileSource;
    String fileDestination;
    final String COMPILED_FILE_EXTENSION = "ta";



// ---------------------------------------------- Constructor -------------------------------------------------- //



    public GameBuilder(ArrayList<String> gameContent, String fileSource, String fileDestination) {
        this.gameContent = gameContent;
        this.fileSource = fileSource;
        this.fileDestination = fileDestination;
    }



// ---------------------------------------------- Methods -------------------------------------------------- //



    public boolean build() {

        File destination = getDestinationPath(); // Wohin es gespeichert werden soll
        File tmpFolder = createTmpFolder();   //Temporärer Ordner in dem die Compilierten Daten gespeichert werden

        String gameName = tmpFolder.getParentFile().getName();

        File gameFile = createGameFileInFolder(tmpFolder, gameName);

        fillTmpGameFile(gameFile);

        File game = makeZip(tmpFolder, destination, gameName);

        deleteAll(tmpFolder);

        return renameGame(game);
    }



    private File getDestinationPath() {
        if(fileDestination.equals("")) {
            File source = new File(fileSource);
            if(source.isFile()) {
                fileDestination = source.getParentFile().getAbsolutePath();
            } else {
                fileDestination = source.getAbsolutePath();
            }
        }
        File destination = new File(fileDestination);
        if(destination.isDirectory()) {
            destination = new File(destination.getAbsolutePath());
        } else {
            throw new IllegalArgumentException("Destination path is not a directory.");
        }
        return destination;
    }


    private boolean fillTmpGameFile(File gameFile) {
        try {
            FileWriter writer = new FileWriter(gameFile);
            for (String line : gameContent) {
                writer.write(line + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    private File makeZip(File source, File destination, String gameName) {
        return ZipManager.zip(source.getAbsolutePath(), destination.getAbsolutePath(), gameName);
    }


    private File createTmpFolder() {
        File soruce = new File(fileSource);
        File tmpFolder;
        if(soruce.isFile()) {
            tmpFolder = new File(soruce.getParentFile().getAbsolutePath() + "/tmp");
        } else {
            tmpFolder = new File(soruce.getAbsolutePath() + "/tmp");
        }

        if(tmpFolder.exists()) {
            deleteAll(tmpFolder);
        }
        tmpFolder.mkdir();
        tmpFolder.deleteOnExit();
        return tmpFolder;
    }


    private File createGameFileInFolder(File folder, String gameName) {
        File gameFile = new File(folder.getAbsolutePath() + "/" + gameName + "." + COMPILED_FILE_EXTENSION);
        if(gameFile.exists()) {
            gameFile.delete();
        }
        try {
            gameFile.createNewFile();
            return gameFile;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    private boolean renameGame(File game) {
        File newGame = new File(game.getParentFile().getAbsolutePath() + "/" + game.getName().replace(".zip", "." + COMPILED_FILE_EXTENSION));
        if(newGame.exists()) {
            newGame.delete();
        }
        return game.renameTo(newGame);
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
