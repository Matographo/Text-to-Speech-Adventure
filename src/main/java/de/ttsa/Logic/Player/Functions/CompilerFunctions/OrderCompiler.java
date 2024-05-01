package de.ttsa.Logic.Player.Functions.CompilerFunctions;

import java.util.ArrayList;

public class OrderCompiler {
    
    public String compileInputOrder(String condition) {
        condition = condition.replace(" ", "");
        StringBuilder compiled = new StringBuilder();
        String[] conditions = getInOrderBool(condition);
        for (int i = 0; i < conditions.length; i++) {
            compiled.append(compileInOrder(conditions[i]));
        }
        return compiled.toString();
    }

    private String compileInOrder(String condition) {
        StringBuilder compiled = new StringBuilder();
        String[] conditions = getOffOrderBool(condition);
        for (int i = 0; i < conditions.length; i++) {
            compiled.append(compileOffOrder(conditions[i]));
        }
        return compiled.toString();
    }   


    private String compileOffOrder(String condition) {
        StringBuilder compiled = new StringBuilder();
        String[] conditions = getConditions(condition);
        for (int i = 0; i < conditions.length; i++) {
            compiled.append((compileCondition(conditions[i])));
        }
        return compiled.toString();
    }

    private String compileCondition(String condition) {
        return condition;
    }

    private String[] getInOrderBool(String condition) {
        if(condition.contains("!")) return condition.split("!");
        else if (condition.contains("&")) return condition.split("&");
        else if (condition.contains("-")) return condition.split("-");
        else return new String[]{condition};
    }

    private String[] getOffOrderBool(String condition) {
        if(condition.contains("!")) return condition.split("!");
        else if (condition.contains("&")) return condition.split("&");
        else if (condition.contains("-")) return condition.split("-");
        else return new String[]{condition};
    }

    private String[] getConditions(String condition) {
        ArrayList<String> conditions = new ArrayList<>();
        char startChar;
        while(!condition.strip().equals("")) {
            startChar = condition.charAt(0);
            condition = condition.substring(1);
            switch (startChar) {
                case '"':
                    conditions.add(startChar + condition.substring(0, condition.indexOf('"')+1));
                    condition = condition.substring(condition.indexOf('"') + 1);
                    break;
                case '\'' :
                    conditions.add(startChar + condition.substring(0, condition.indexOf('\'')+1));
                    condition = condition.substring(condition.indexOf('\'') + 1);
                    break;
                case '@':
                    conditions.add(startChar + condition.substring(0, getPosition(condition)));
                    break;
            
                default:
                    break;
            }
        }
        return conditions.toArray(new String[conditions.size()]);
    }

    private int getPosition(String condition) {
        int position = condition.length();
        if(condition.indexOf("\"") < position) position = condition.indexOf("\"");
        if(condition.indexOf("'") < position) position = condition.indexOf("'");
        if(condition.indexOf("@") < position) position = condition.indexOf("@");
        return position;
    }
}
