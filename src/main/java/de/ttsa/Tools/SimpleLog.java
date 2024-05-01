package de.ttsa.Tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SimpleLog extends Logger {



// ----------------------------------------  Attributes  ---------------------------------------- //



    HashMap<Level, Color>  msgTextColor         = new HashMap<>();
    HashMap<Level, Color>  msgBackgroundColor   = new HashMap<>();
    HashMap<Level, Color>  levelColor           = new HashMap<>();
    HashMap<Level, Color>  levelBackgroundColor = new HashMap<>();
    HashMap<Level, String> levelText            = new HashMap<>();



// ------------------------------------------  Enums  ------------------------------------------ //



    public enum Color {
        DEFAULT(39),
        BLACK(30),
        RED(31),
        GREEN(32),
        YELLOW(33),
        BLUE(34),
        PURPLE(35),
        CYAN(36),
        WHITE(37),
        RESET(0);

        private final int code;

        Color(int code) {
            this.code = code;
        }

        public String getTextColor() {
            if(code == 0) return "\u001B[0m";
            return "\u001B[" + code + "m";
        }

        public String getBackgroundColor() {
            return "\u001B[" + (code + 10) + "m";
        }
    }



// ----------------------------------------  Constructors  ---------------------------------------- //



    protected SimpleLog(String name, String resourceBundleName) {
        super(name, resourceBundleName);
        autoSetLevelColor();
    }



// -----------------------------------------  autoSetup  ----------------------------------------- //



    private void autoSetLevelColor() {
        // Message Text Color
        msgTextColor.put(Level.SEVERE, Color.RED);
        msgTextColor.put(Level.WARNING, Color.YELLOW);
        msgTextColor.put(Level.INFO, Color.BLUE);
        msgTextColor.put(Level.CONFIG, Color.GREEN);
        msgTextColor.put(Level.FINE, Color.CYAN);
        msgTextColor.put(Level.FINER, Color.PURPLE);
        msgTextColor.put(Level.FINEST, Color.WHITE);

        // Message Background Color
        msgBackgroundColor.put(Level.SEVERE, Color.DEFAULT);
        msgBackgroundColor.put(Level.WARNING, Color.DEFAULT);
        msgBackgroundColor.put(Level.INFO, Color.DEFAULT);
        msgBackgroundColor.put(Level.CONFIG, Color.DEFAULT);
        msgBackgroundColor.put(Level.FINE, Color.DEFAULT);
        msgBackgroundColor.put(Level.FINER, Color.DEFAULT);
        msgBackgroundColor.put(Level.FINEST, Color.DEFAULT);

        // Level Text Color
        levelColor.put(Level.SEVERE, Color.RED);
        levelColor.put(Level.WARNING, Color.YELLOW);
        levelColor.put(Level.INFO, Color.BLUE);
        levelColor.put(Level.CONFIG, Color.GREEN);
        levelColor.put(Level.FINE, Color.CYAN);
        levelColor.put(Level.FINER, Color.PURPLE);
        levelColor.put(Level.FINEST, Color.WHITE);

        // Level Background Color
        levelBackgroundColor.put(Level.SEVERE, Color.DEFAULT);
        levelBackgroundColor.put(Level.WARNING, Color.DEFAULT);
        levelBackgroundColor.put(Level.INFO, Color.DEFAULT);
        levelBackgroundColor.put(Level.CONFIG, Color.DEFAULT);
        levelBackgroundColor.put(Level.FINE, Color.DEFAULT);
        levelBackgroundColor.put(Level.FINER, Color.DEFAULT);
        levelBackgroundColor.put(Level.FINEST, Color.DEFAULT);

        // Level Text
        levelText.put(Level.SEVERE, "ERROR");
        levelText.put(Level.WARNING, "WARNING");
        levelText.put(Level.INFO, "INFO");
        levelText.put(Level.CONFIG, "CONFIG");
        levelText.put(Level.FINE, "DEBUG");
        levelText.put(Level.FINER, "TRACE");
        levelText.put(Level.FINEST, "DETAILED TRACE");
    }



// ------------------------------------------  Factorys  ------------------------------------------ //



    public static SimpleLog getLogger(Class<?> clazz) {
        return new SimpleLog(clazz.getName(), null).setConfiguration();
    }

    public static SimpleLog getLogger(String name) {
        return new SimpleLog(name, null).setConfiguration();
    }

    public static SimpleLog getLogger() {
        return new SimpleLog(Logger.GLOBAL_LOGGER_NAME, null).setConfiguration();
    }



// ------------------------------------------  Configurations  ------------------------------------------ //



    private SimpleLog setConfiguration() {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(getFormatter());
        this.addHandler(handler);

        return this;
    }

    private SimpleFormatter getFormatter() {
        SimpleFormatter formatter = new SimpleFormatter() {
            @Override
            public String format(LogRecord record) {
                Level level    = record.getLevel();
                String message = record.getMessage();

                return "[" + getLevelText(level) + "] " + getMsg(message, level) + "\n";
            }
        };
        return formatter;
    }



// ------------------------------------------  Formatter  ------------------------------------------ //



    private String getLevelText(Level level) {
        StringBuilder levelText = new StringBuilder();

        levelText.append(levelColor.get(level).getTextColor());
        levelText.append(levelBackgroundColor.get(level).getBackgroundColor());
        levelText.append(this.levelText.get(level));
        levelText.append(Color.RESET.getTextColor());
        levelText.append(Color.RESET.getBackgroundColor());

        return levelText.toString();
    }

    private String getMsg(String msg, Level level) {
        StringBuilder msgText = new StringBuilder();

        msgText.append(msgTextColor.get(level).getTextColor());
        msgText.append(msgBackgroundColor.get(level).getBackgroundColor());
        msgText.append(msg);
        msgText.append(Color.RESET.getTextColor());
        msgText.append(Color.RESET.getBackgroundColor());

        return msgText.toString();
    }



// ------------------------------------------  Log Methods  ------------------------------------------ //



    public void debug(String msg) {
        log(Level.FINE, msg);
    }

    public void trace(String msg) {
        log(Level.FINER, msg);
    }

    public void detailedTrace(String msg) {
        log(Level.FINEST, msg);
    }

    public void error(String msg) {
        log(Level.SEVERE, msg);
    }

    public void warn(String msg) {
        log(Level.WARNING, msg);
    }

    public void critical(String msg) {
        log(Level.SEVERE, msg);
    }

    public void crit(String msg) {
        log(Level.SEVERE, msg);
    }



// ------------------------------------------  Setters  ------------------------------------------ //



    public void setTextColor(Level level, Color color) {
        msgTextColor.put(level, color);
    }

    public void setBackgroundColor(Level level, Color color) {
        msgBackgroundColor.put(level, color);
    }

    public void setLevelColor(Level level, Color color) {
        levelColor.put(level, color);
    }

    public void setLevelBackgroundColor(Level level, Color color) {
        levelBackgroundColor.put(level, color);
    }

    public void setLevelText(Level level, String text) {
        levelText.put(level, text);
    }

    public void setFilePath(String filename) throws IOException {
        setFilePath(filename, Level.ALL);
    }

    public void setFilePath(String filename, Level level) throws IOException {
        FileHandler fileHandler = new FileHandler(filename);
        fileHandler.setLevel(level);
        fileHandler.setFormatter(getFileFormatter());
        this.addHandler(fileHandler);
    }



// ------------------------------------------  Getters  ------------------------------------------ //



    private SimpleFormatter getFileFormatter() {
        SimpleFormatter formatter = new SimpleFormatter() {
            @Override
            public String format(LogRecord record) {
                Level level = record.getLevel();
                String message = record.getMessage();
                return "[" + levelText.get(level) + "] " + message + "\n";
            }
        };
        return formatter;
    }


    public Level getLevelDebug() {
        return Level.FINE;
    }

    public Level getLevelTrace() {
        return Level.FINER;
    }

    public Level getLevelDetailedTrace() {
        return Level.FINEST;
    }

    public Level getLevelError() {
        return Level.SEVERE;
    }

    public Level getLevelCritical() {
        return Level.SEVERE;
    }
    
}