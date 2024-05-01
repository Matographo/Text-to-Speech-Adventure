package de.ttsa.Logic.Features.Set;

import java.util.HashSet;

import de.ttsa.Logic.Player.PlayerLogic.GameManager;

public class Set {


// ---------------------------------------------- Attributes -------------------------------------------------- //



    HashSet<String> str;
    HashSet<String> var;


    
// ---------------------------------------------- Constructor ------------------------------------------------- //



    /**
     * Constructor for Set
     * @param str the set of strings
     * @param var the set of variables
     */
    public Set(HashSet<String> str, HashSet<String> var) {
        this.str = str;
        this.var = var;
    }



// ----------------------------------------------- Methods ---------------------------------------------------- //


    /**
     * Get the set of strings
     * @return the set of strings
     */
    public HashSet<String> getStr() {
        return str;
    }

    /**
     * Get the set of variables
     * @return the set of variables
     */
    public HashSet<String> getVar() {
        return var;
    }

    public boolean contains(String str) {
        for(String value : this.var) {
            if(GameManager.strVars.get(value).getValue().equals(str)) {
                return true;
            }
        }
        return this.str.contains(str);
    }



}
