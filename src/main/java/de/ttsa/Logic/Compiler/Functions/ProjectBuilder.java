package de.ttsa.Logic.Compiler.Functions;

import java.io.File;

import de.ttsa.Logic.Compiler.Functions.Properties.GameProperty;

public class ProjectBuilder {
    
    private String path;
    private final String GAME_EXTENSION = ".tac";

    public ProjectBuilder(String path) {
        this.path = path;
    }

    public void build() {
        File projectFolder = new File(path);
        testValidPath(projectFolder);

        new ProjectFolderBuilder(projectFolder).buildProjectFolderTree();
        new GameProperty(projectFolder).createDefault().setGameTitle(projectFolder.getName()).save();

        createGameFile(projectFolder);
    }


    private void testValidPath(File path) {
        if(path.exists()) {
            throw new RuntimeException("Project already exists");
        }
        if(!path.getParentFile().exists()) {
            throw new RuntimeException("Path does not exist");
        }
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

}
