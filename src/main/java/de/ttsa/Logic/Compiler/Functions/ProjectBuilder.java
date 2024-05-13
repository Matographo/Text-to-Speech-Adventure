package de.ttsa.Logic.Compiler.Functions;

import java.io.File;

public class ProjectBuilder {
    
    private String path;
    private final String GAME_EXTENSION = ".tac";

    public ProjectBuilder(String path) {
        this.path = path;
    }

    public void build() {
        File projectFolder = new File(path);
        if(projectFolder.exists()) {
            throw new RuntimeException("Project already exists");
        }
        if(!projectFolder.getParentFile().exists()) {
            throw new RuntimeException("Path does not exist");
        }


        crateProjectFolder(projectFolder);
        createResourceFolder(projectFolder);
        createSourceFolder(projectFolder);
        createLibFolder(projectFolder);
        createGameFile(projectFolder);
    }



// ------------------------------ Project Folder ------------------------------ //



    private void crateProjectFolder(File projectFolder) {
        projectFolder.mkdir();
    }



// ------------------------------ Resource Folder ------------------------------ //



    private void createResourceFolder(File projectFolder) {
        File assetFolder = createFolder(projectFolder, "assets");

        File imageFolder = createFolder(assetFolder, "image");
        File soundFolder = createFolder(assetFolder, "sound");
        File musicFolder = createFolder(assetFolder, "music");
    }


// ------------------------------ Source Folder ------------------------------ //



    private void createSourceFolder(File projectFolder) {
        File sourceFolder = createFolder(projectFolder, "src");

        File roomFolder = createFolder(sourceFolder, "rooms");
        File actionFolder = createFolder(sourceFolder, "actions");
        File subScriptFolder = createFolder(sourceFolder, "subScripts");
        File setFolder = createFolder(sourceFolder, "sets");
    }



// ------------------------------ Lib Folder ------------------------------ //



    private void createLibFolder(File projectFolder) {
        File libFolder = createFolder(projectFolder, "lib");
    }


// ------------------------------ Game File ------------------------------ //



    private void createGameFile(File projectFolder) {
        File gameFile = new File(projectFolder, "game" + GAME_EXTENSION);
        try {
            gameFile.createNewFile();
        } catch (Exception e) {
            throw new RuntimeException("there was an error creating the game file");
        }
    }


// ------------------------------ Help Methods ------------------------------ //


    private File createFolder(File parentFolder, String folderName) {
        File folder = new File(parentFolder, folderName);
        folder.mkdir();
        return folder;
    }



}
