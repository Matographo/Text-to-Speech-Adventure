package de.ttsa.Logic.Compiler.Functions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

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
        
        File libActionFolder = createFolder(libFolder, "action");
        File libSetFolder = createFolder(libFolder, "set");

        copyLibFiles(libActionFolder, "action");
        copyLibFiles(libSetFolder, "set");
    }

    private void copyLibFiles(File libFolder, String libName) {
        try {
            URI uri = getClass().getResource("/ProjectTemplate/lib/" + libName + "/").toURI();
            Path sourcePath;
            if (uri.getScheme().equals("jar")) {
                try (FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
                    sourcePath = fileSystem.getPath("/ProjectTemplate/lib/" + libName + "/");
                    copyDirectory(sourcePath, libFolder.toPath());
                }
            } else {
                sourcePath = Paths.get(uri);
                copyDirectory(sourcePath, libFolder.toPath());
            }
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void copyDirectory(Path source, Path target) throws IOException {
        Files.walk(source).forEach(sourcePath -> {
            try {
                Path targetPath = target.resolve(source.relativize(sourcePath));
                Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }




// ------------------------------ Help Methods ------------------------------ //



private File createFolder(File parentFolder, String folderName) {
    File folder = new File(parentFolder, folderName);
    folder.mkdir();
    return folder;
}


}
