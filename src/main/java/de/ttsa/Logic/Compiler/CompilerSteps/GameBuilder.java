package de.ttsa.Logic.Compiler.CompilerSteps;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import de.ttsa.Frontend.Terminal.CompilerApp;
import de.ttsa.Logic.Compiler.Functions.ProjectObject;
import de.ttsa.Tools.SimpleLog;
import de.ttsa.Tools.ZipManager;

public class GameBuilder {



// ---------------------------------------------- Attributes -------------------------------------------------- //



    final String COMPILED_FILE_EXTENSION = "ta";
    ProjectObject projectObject;
    private SimpleLog log = CompilerApp.log;



// ---------------------------------------------- Constructor -------------------------------------------------- //



    public GameBuilder(ArrayList<String> gameContent, String fileSource, String fileDestination) {
        projectObject = new ProjectObject();
        projectObject.setGameContent(gameContent);
        projectObject.setPaths(fileSource, fileDestination);
    }



// ---------------------------------------------- Methods -------------------------------------------------- //



    public boolean build() {

        File tmpFolder = createTmpFolder();   //Temporärer Ordner in dem die Compilierten Daten gespeichert werden

        projectObject.setProjectName(tmpFolder.getParentFile().getName());
        projectObject.identifyProperties();

        File gameFile = createGameFileInFolder(tmpFolder, "game");

        fillTmpGameFile(gameFile);
        createAndFillMetaDataFile(tmpFolder);
        copyAssetFolder(tmpFolder);

        File game = makeZip(tmpFolder, projectObject.getDestinationPath(), projectObject.getProjectName());

        deleteAll(tmpFolder);

        return renameGame(game);
    }


    private boolean fillTmpGameFile(File gameFile) {
        try {
            FileWriter writer = new FileWriter(gameFile);
            for (String line : projectObject.getGameContent()) {
                writer.write(line + "\n");
            }
            writer.close();
            return true;
        } catch (IOException e) {
            log.trace(e.getStackTrace().toString());
            return false;
        }
    }


    private File makeZip(File source, File destination, String gameName) {
        return ZipManager.zip(source.getAbsolutePath(), destination.getAbsolutePath(), gameName);
    }


    private File createTmpFolder() {
        File tmpFolder;
        if(projectObject.getSourcePath().isFile()) {
            tmpFolder = new File(projectObject.getSourcePath().getParentFile().getAbsolutePath() + "/tmp");
        } else {
            tmpFolder = new File(projectObject.getSourcePath().getAbsolutePath() + "/tmp");
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
            log.trace(e.getStackTrace().toString());
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
    

    private void createAndFillMetaDataFile(File folder) {
        File metaData = new File(folder.getAbsolutePath() + "/game.properties");
        try {
            metaData.createNewFile();
            FileWriter writer = new FileWriter(metaData);
            for (String key : projectObject.getProjectProperties().stringPropertyNames()) {
                writer.write(key + "=" + projectObject.getProjectProperties().getProperty(key) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            log.trace(e.getStackTrace().toString());
        }
    }

    private void copyAssetFolder(File folder) {
        File assetFolder = new File(projectObject.getSourcePath().getAbsolutePath() + "/assets");
        File newAssetFolder = new File(folder.getAbsolutePath());
        if(assetFolder.exists()) {
            newAssetFolder.mkdir();
            try {
                copyFolder(assetFolder.toPath(), newAssetFolder.toPath());
            } catch (IOException e) {
                log.trace(e.getStackTrace().toString());
            }
        }
    }
    
    private void copyFolder(Path source, Path destination) throws IOException {
        Files.walk(source).forEachOrdered(sourcePath -> {
            try {
                Path destinationPath = destination.resolve(source.relativize(sourcePath));
                if (Files.isDirectory(sourcePath)) {
                    if (!Files.exists(destinationPath)) {
                        Files.createDirectories(destinationPath);
                    }
                } else {
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw new RuntimeException("Fehler beim Kopieren von Dateien", e);
            }
        });
    }
    
}
