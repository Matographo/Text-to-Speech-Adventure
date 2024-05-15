package de.ttsa.Logic.Compiler.Functions;

import java.io.File;

public class ProjectFolderBuilder {
    

    private File projectPath;


    public ProjectFolderBuilder(File projectPath) {
        this.projectPath = projectPath;
    }

    public void buildProjectFolderTree() {
        crateProjectFolder(projectPath);
        createResourceFolder(projectPath);
        createSourceFolder(projectPath);
        createLibFolder(projectPath);
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



// ------------------------------ Help Methods ------------------------------ //



private File createFolder(File parentFolder, String folderName) {
    File folder = new File(parentFolder, folderName);
    folder.mkdir();
    return folder;
}


}
