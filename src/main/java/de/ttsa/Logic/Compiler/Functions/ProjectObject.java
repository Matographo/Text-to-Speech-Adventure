package de.ttsa.Logic.Compiler.Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ProjectObject {

    private String projectName;
    private File destinationPath;
    private File sourcePath;

    private Properties projectProperties;
    private List<String> gameContent;
    private List<File> music;
    private List<File> sound;
    private List<File> images;

    public ProjectObject() {
        
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public File getDestinationPath() {
        return destinationPath;
    }

    public Properties getProjectProperties() {
        return projectProperties;
    }

    public void setProjectProperties(Properties projectProperties) {
        this.projectProperties = projectProperties;
    }

    public List<String> getGameContent() {
        return gameContent;
    }

    public void setGameContent(ArrayList<String> gameContent) {
        this.gameContent = gameContent;
    }
    
    public void addGameContent(List<String> gameContent) {
        this.gameContent.addAll(gameContent);
    }

    public File getSourcePath() {
        return sourcePath;
    }

    public void setPaths(String sourcePath, String destinationPath) {
        this.sourcePath = new File(sourcePath);
        if(destinationPath.isBlank()) {
            if(this.sourcePath.isFile()) {
                this.destinationPath = new File(this.sourcePath.getParentFile().getAbsolutePath());
            } else {
                this.destinationPath = new File(this.sourcePath.getAbsolutePath());
            }
        }
    }

    public List<File> getMusic() {
        return music;
    }

    public void setMusic(List<File> music) {
        this.music = music;
    }

    public List<File> getSound() {
        return sound;
    }

    public void setSound(List<File> sound) {
        this.sound = sound;
    }

    public List<File> getImages() {
        return images;
    }

    public void setImages(List<File> images) {
        this.images = images;
    }

    public void identifyProperties() {
        projectProperties = new Properties();
        try {
            this.projectProperties.load(new FileInputStream(new File(sourcePath, "game.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
