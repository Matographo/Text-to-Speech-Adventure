package de.ttsa.ConsoleGame.Player.SubFunctions;

public class StringMethodes {
    
    protected String getNextSubstring(String identifier, String string) {
        return getNextSubstring(identifier, identifier, string);
    }

    protected String getNextSubstring(String first, String last, String string) {
        if(!hasBlock(first, last, string)) return null;
        int firstIndex = string.indexOf(first);
        int lastIndex = string.indexOf(last, firstIndex+1);
        return string.substring(firstIndex+1, lastIndex);
    }

    protected String getSubstringUntilBlock(String string, String... identifier) {

        for(String id : identifier) {
            if(string.contains(id)) {
                string = string.substring(0, string.indexOf(id));
            }
        }
        return string;
    }

    protected String deleteUntilSubstring(String identifier, String string) {
        return deleteUntilSubstring(identifier, identifier, string);
    }

    protected String deleteUntilSubstring(String first, String last, String string) {
        if(!hasBlock(first, last, string)) return string;
        return string.substring(string.indexOf(first, string.indexOf(string.indexOf(first))), string.indexOf(last, string.indexOf(string.indexOf(first))));
    }

    protected String deleteUntilAfterSubstring(String identifier, String string) {
        return deleteUntilAfterSubstring(identifier, identifier, string);
    }

    protected String deleteUntilAfterSubstring(String first, String last, String string) {
        if(!hasBlock(first, last, string)) return string;
        int index = string.indexOf(first);
        string = string.substring(index+1);
        return string.substring(string.indexOf(last)+1);
    }

    protected String deleteFirstAndLast(String identifier, String string) {
        if(!string.startsWith(identifier) || !string.endsWith(identifier)) return string;
        return string.substring(1, string.length() - 1);
    }

    protected String deleteFirstAndLast(String first, String last, String string) {
        if(!string.startsWith(first) || !string.endsWith(last)) return string;
        return string.substring(first.length(), string.length() - last.length());
    }

    protected boolean checkFirstAndLast(String identifier, String string) {
        return checkFirstAndLast(identifier, identifier, string);
    }

    protected boolean checkFirstAndLast(String first, String last, String string) {
        if(string.startsWith(first) && string.endsWith(last)) return true;
        return false;
    }

    protected boolean checkIfStartOrEnd(String identifier, String... string) {
        for(String str : string) {
            if(str.startsWith(identifier) || str.endsWith(identifier)) return true;
        }
        return false;
    }

    protected boolean checkIfContains(String string, String... toCheck) {
        for(String str : toCheck) {
            if(string.contains(str)) return true;
        }
        return false;
    }

    protected boolean hasBlock(String first, String last, String string) {
        return string.indexOf(first) < string.lastIndexOf(last);
    }

    protected boolean hasBlock(String identifier, String string) {
        return hasBlock(identifier, identifier, string);
    }

    protected String getUntilSubstring(String identifier, String string) {
        return string.substring(0, string.indexOf(identifier));
    }
}
