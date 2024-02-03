package de.ttsa.ConsoleGame.Player.SubFunctions;

public class StringMethodes {
    

    /**
     * Get the next substring between the first and the last identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return the next substring between the first and the last identifier
     */
    protected String getNextSubstring(String identifier, String string) {
        return getNextSubstring(identifier, identifier, string);
    }

    /**
     * Get the next substring between the first and the last identifier
     * @param first the first identifier that should be used
     * @param last the last identifier that should be used
     * @param string the string that should be used
     * @return the next substring between the first and the last identifier
     */
    protected String getNextSubstring(String first, String last, String string) {
        if(!hasBlock(first, last, string)) return null;
        int firstIndex = string.indexOf(first);
        int lastIndex = string.indexOf(last, firstIndex+1);
        return string.substring(firstIndex+1, lastIndex);
    }

    /**
     * Get the next substring until the first identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return the next substring until the first identifier
     */
    protected String getSubstringUntilBlock(String string, String... identifier) {

        for(String id : identifier) {
            if(string.contains(id)) {
                string = string.substring(0, string.indexOf(id));
            }
        }
        return string;
    }

    /**
     * Get the next substring until the first identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return the next substring until the first identifier
     */
    protected String deleteUntilSubstring(String identifier, String string) {
        return deleteUntilSubstring(identifier, identifier, string);
    }

    /**
     * Get the next substring until the first identifier
     * @param first the first identifier that should be used
     * @param last the last identifier that should be used
     * @param string the string that should be used
     * @return the next substring until the first identifier
     */
    protected String deleteUntilSubstring(String first, String last, String string) {
        if(!hasBlock(first, last, string)) return string;
        return string.substring(string.indexOf(first, string.indexOf(string.indexOf(first))), string.indexOf(last, string.indexOf(string.indexOf(first))));
    }

    /**
     * Get the next substring until the first identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return the next substring until the first identifier
     */
    protected String deleteUntilAfterSubstring(String identifier, String string) {
        return deleteUntilAfterSubstring(identifier, identifier, string);
    }

    /**
     * Get the next substring until the first identifier
     * @param first the first identifier that should be used
     * @param last the last identifier that should be used
     * @param string the string that should be used
     * @return the next substring until the first identifier
     */
    protected String deleteUntilAfterSubstring(String first, String last, String string) {
        if(!hasBlock(first, last, string)) return string;
        int index = string.indexOf(first);
        string = string.substring(index+1);
        return string.substring(string.indexOf(last)+1);
    }

    /**
     * Delete the first and the last identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return the string without the first and the last identifier
     */
    protected String deleteFirstAndLast(String identifier, String string) {
        if(!string.startsWith(identifier) || !string.endsWith(identifier)) return string;
        return string.substring(1, string.length() - 1);
    }

    /**
     * Delete the first and the last identifier
     * @param first the first identifier that should be used
     * @param last the last identifier that should be used
     * @param string the string that should be used
     * @return the string without the first and the last identifier
     */
    protected String deleteFirstAndLast(String first, String last, String string) {
        if(!string.startsWith(first) || !string.endsWith(last)) return string;
        return string.substring(first.length(), string.length() - last.length());
    }

    /**
     * Check if the string starts or ends with the identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return true if the string starts or ends with the identifier
     */
    protected boolean checkFirstAndLast(String identifier, String string) {
        return checkFirstAndLast(identifier, identifier, string);
    }

    /**
     * Check if the string starts or ends with the identifier
     * @param first the first identifier that should be used
     * @param last the last identifier that should be used
     * @param string the string that should be used
     * @return true if the string starts or ends with the identifier
     */
    protected boolean checkFirstAndLast(String first, String last, String string) {
        if(string.startsWith(first) && string.endsWith(last)) return true;
        return false;
    }

    /**
     * Check if the string contains the identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return true if the string contains the identifier
     */
    protected boolean checkIfStartOrEnd(String identifier, String... string) {
        for(String str : string) {
            if(str.startsWith(identifier) || str.endsWith(identifier)) return true;
        }
        return false;
    }

    /**
     * Check if the string contains the identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return true if the string contains the identifier
     */
    protected boolean checkIfContains(String string, String... toCheck) {
        for(String str : toCheck) {
            if(string.contains(str)) return true;
        }
        return false;
    }

    /**
     * Check if the string contains the identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return true if the string contains the identifier
     */
    protected boolean hasBlock(String first, String last, String string) {
        return string.indexOf(first) < string.lastIndexOf(last);
    }

    /**
     * Check if the string contains the identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return true if the string contains the identifier
     */
    protected boolean hasBlock(String identifier, String string) {
        return hasBlock(identifier, identifier, string);
    }

    /**
     * Get the next substring until the first identifier
     * @param identifier the identifier that should be used
     * @param string the string that should be used
     * @return the next substring until the first identifier
     */
    protected String getUntilSubstring(String identifier, String string) {
        return string.substring(0, string.indexOf(identifier));
    }
}
