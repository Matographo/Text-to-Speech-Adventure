package de.ttsa.Logic.Compiler.Functions.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyLoader {
    
    private File propertiesPath;


    public PropertyLoader(File file) {
        propertiesPath = file;
    }

    public Properties load() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesPath));
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
