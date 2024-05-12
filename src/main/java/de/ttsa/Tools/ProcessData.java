package de.ttsa.Tools;

public class ProcessData {
    
    public static final String os = System.getProperty("os.name").toLowerCase();

    public static String getTerminalName() {
        if (os.contains("windows")) {
            return "cmd.exe";
        } else if (os.contains("linux") || os.contains("mac")) {
            return "/bin/bash";
        } else {
            throw new IllegalArgumentException("OS wird nicht unterstützt");
        }
    }

    public static boolean isWindows() {
        return os.contains("windows");
    }

    public static boolean isLinux() {
        return os.contains("linux");
    }

    public static boolean isMac() {
        return os.contains("mac");
    }
}
