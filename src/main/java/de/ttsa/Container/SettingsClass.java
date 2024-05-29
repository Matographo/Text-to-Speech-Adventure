package de.ttsa.Container;

import java.util.Properties;

import de.ttsa.AppStart;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SettingsClass {

    Properties properties;

    private String startDir;

    public SettingsClass(String path) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
            startDir = properties.getProperty("startDir");

            if (!(startDir != null && !startDir.isEmpty())) {
                startDir = System.getProperty("user.home");
                properties.setProperty("startDir", startDir);
                properties.store(new FileOutputStream(path), "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getStartDir() {
        return startDir;
    }

    public void setStartDir(String startDir) {
        if (startDir == null || startDir.isEmpty()) {
            this.startDir = System.getProperty("user.home");
        } else {
            this.startDir = startDir;
        }
        properties.setProperty("startDir", this.startDir);
        try {
            properties.store(new FileOutputStream(AppStart.settingsPath), "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}