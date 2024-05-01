package de.ttsa.Container.InputContainerPlayer;

import java.util.List;
import java.util.ArrayList;

import de.ttsa.Container.Range;
import de.ttsa.Container.Triple;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Parents.StringMethods;

public class OfforderChecker extends StringMethods {
    
    private List<Triple<Character, WordChecker, Range>> wordorders;
    private boolean isNot;
    private boolean onlyMode;

    public OfforderChecker(String toCheck, boolean onlyMode) {
        wordorders = new ArrayList<>();
        char booleanOperator;
        char varType;
        String occurance;
        StringBuilder wordOrder = new StringBuilder();
        if(toCheck.startsWith(InputChecker.NOT.toString())) {
            this.isNot = true;
            toCheck = toCheck.substring(1);
        }
        while(toCheck.length() > 0) {
            if(toCheck.startsWith("AND") ||
               toCheck.startsWith("OR")) {
                booleanOperator = toCheck.charAt(0);
                toCheck = toCheck.substring(1);
            } else {
                booleanOperator = 0;
            }

            varType = getFirstChar(toCheck, '\'', '"', '@');
            wordOrder.append(toCheck.substring(0, toCheck.indexOf(varType)+1));
            toCheck = toCheck.substring(toCheck.indexOf(varType)+1);
            occurance = toCheck.substring(0, toCheck.indexOf(")")+1);
            toCheck = toCheck.substring(toCheck.indexOf(")")+1);
            wordorders.add(new Triple<Character, WordChecker, Range>(booleanOperator, new WordChecker(wordOrder.toString()), new Range(occurance)));
            wordOrder = new StringBuilder();
        }
    }

    public boolean check(List<String> words) {
        boolean result = true;
        int last = words.size();
        List<Triple<Character, WordChecker, Range>> wordorders = new ArrayList<>(this.wordorders);
        Triple<Character, WordChecker, Range> test;

        for(int i=0; i<wordorders.size(); i++) {
            test = wordorders.get(i);
            for(int j=0; j<words.size(); j++) {
                if(test.getC().isInRange()) {
                    if(test.getB().check(words.get(j))) {
                        test.getC().decrease();
                        words.remove(j);
                        if(j<last) {
                            last = j;
                        }
                    }
                } else {
                    break;
                }
            }
            if(test.getC().isInRange()) {
                result = false;
            }

        }

        if(onlyMode && last != 0) {
            result = false;
        }

        return result && !isNot;
    }
}
