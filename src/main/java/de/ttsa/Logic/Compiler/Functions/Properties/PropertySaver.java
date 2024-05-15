package de.ttsa.Logic.Compiler.Functions.Properties;

import java.io.File;
import java.util.Properties;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PropertySaver {
    
    private Properties properie;
    private File propertiesPath;

    public PropertySaver(Properties properties, File file) {
        properie = properties;
        propertiesPath = file;
    }

    public boolean save() {
        if(properie.getProperty("gameReleaseDate") == null || properie.getProperty("gameReleaseDate").isBlank()) {
            properie.setProperty("gameReleaseDate", getCurrentDate());
        }
        fileConfig();
        try {
            properie.store(new FileOutputStream(propertiesPath), "Properties");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getCurrentDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    private void fileConfig() {
        if(!propertiesPath.exists()) {
            try {
                propertiesPath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
