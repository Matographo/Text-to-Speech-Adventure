package de.ttsa.Logic.Compiler.Functions;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        File libVariablesFolder = createFolder(libFolder, "variables");

        Map<String, List<String>> actions   = copyLibFiles("action");
        Map<String, List<String>> set       = copyLibFiles("set");
        Map<String, List<String>> variables = copyLibFiles("variables");

        createFilesFromMap(libActionFolder.getPath(), actions);
        createFilesFromMap(libSetFolder.getPath(), set);
        createFilesFromMap(libVariablesFolder.getPath(), variables);
    }

    private Map<String, List<String>> copyLibFiles(String libName) {
        Map<String, List<String>> fileContentsMap = new HashMap<>();

        try {
            URI uri = getClass().getResource("/ProjectTemplate/lib/" + libName + "/").toURI();
            Path sourcePath;
            if (uri.getScheme().equals("jar")) {
                try (FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.emptyMap())) {
                    sourcePath = fileSystem.getPath("/ProjectTemplate/lib/" + libName + "/");
                    fileContentsMap = readFilesIntoMap(sourcePath);
                }
            } else {
                sourcePath = Paths.get(uri);
                fileContentsMap = readFilesIntoMap(sourcePath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileContentsMap;
    }

    private Map<String, List<String>> readFilesIntoMap(Path directory) throws IOException {
        Map<String, List<String>> fileContentsMap = new HashMap<>();

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path path : directoryStream) {
                if (!Files.isDirectory(path)) {
                    String fileName = path.getFileName().toString();
                    List<String> fileContents = Files.readAllLines(path);
                    fileContentsMap.put(fileName, fileContents);
                }
            }
        }

        return fileContentsMap;
    }

    public void createFilesFromMap(String directoryPath, Map<String, List<String>> fileContentsMap) {
        try {
            for (Map.Entry<String, List<String>> entry : fileContentsMap.entrySet()) {
                Path filePath = Paths.get(directoryPath, entry.getKey());
                Files.write(filePath, entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




// ------------------------------ Help Methods ------------------------------ //



    private File createFolder(File parentFolder, String folderName) {
        File folder = new File(parentFolder, folderName);
        folder.mkdir();
        return folder;
    }


}
