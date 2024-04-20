package de.ttsa.Logic.Compiler.OpCodeTester;

import java.util.HashMap;
import java.util.HashSet;

public class OpCodeVar {


// --------------------------------- Attributes ---------------------------------------- //



    private HashSet<String> roomNames;
    private HashSet<String> varNames;
    private HashSet<String> numNames;
    private HashSet<String> strNames;
    private HashSet<String> actionNames;
    private HashSet<String> setNames;

    private HashMap<String, String> actionArgs = new HashMap<>();



// --------------------------------- Constructor ---------------------------------------- //



    public OpCodeVar() {
        roomNames   = new HashSet<String>();
        varNames    = new HashSet<String>();
        numNames    = new HashSet<String>();
        strNames    = new HashSet<String>();
        actionNames = new HashSet<String>();
        setNames    = new HashSet<String>();
    }

    public OpCodeVar(HashSet<String> roomNames, HashSet<String> varNames, HashSet<String> numNames, HashSet<String> strNames, HashSet<String> actionNames, HashSet<String> setNames) {
        this.roomNames = roomNames;
        this.varNames = varNames;
        this.numNames = numNames;
        this.strNames = strNames;
        this.actionNames = actionNames;
        this.setNames = setNames;

    }



// --------------------------------- Methods ---------------------------------------- //


//********************************** Adder *****************************************//
    public boolean addRoomName(String name) {
        return roomNames.add(name);
    }

    public boolean addNumName(String name) {
        return varNames.add(name) && numNames.add(name);
    }

    public boolean addStrName(String name) {
        return varNames.add(name) && strNames.add(name);
    }

    public boolean addActionName(String name) {
        return actionNames.add(name);
    }

    public boolean addSetName(String name) {
        return setNames.add(name);
    }

    public void addActionArgs(String name, String args) {
        actionArgs.put(name, args);
    }

//********************************** Asker ****************************************//
    public boolean isRoomName(String name) {
        return roomNames.contains(name);
    }

    public boolean isVarName(String name) {
        return varNames.contains(name);
    }

    public boolean isNumName(String name) {
        return numNames.contains(name);
    }

    public boolean isStrName(String name) {
        return strNames.contains(name);
    }

    public boolean isActionName(String name) {
        return actionNames.contains(name);
    }

    public boolean isSetName(String name) {
        return setNames.contains(name);
    }

    public String getActionArgs(String name) {
        return actionArgs.get(name);
    }
}
