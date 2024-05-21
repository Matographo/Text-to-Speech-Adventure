package de.ttsa.Tools;

public class Formater {
    
    

    public static String format(long ms) {
        String formatted = "";
        if(ms < 1000) {
            return ms + "ms";
        } else if (ms < 60000) {
            formatted = "" + ms;
            int length = formatted.length();
            return ms / 1000 + "." + formatted.substring(length - 3, length - 1)  + "s";
        } else {
            return ms / 60000 + "m " + (ms % 60000) / 1000 + "s";
        }
    }
}
