package de.ttsa.Container.InputContainerPlayer;

import java.util.List;
import java.util.ArrayList;

import de.ttsa.Container.Couple;
import de.ttsa.Container.Range;
import de.ttsa.Container.Triple;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Parents.StringMethods;

public class OfforderChecker extends StringMethods {
    
    private List<Couple<WordChecker, Range>> wordorders;
    private boolean isNot;
    private boolean onlyMode;
    private Range occurance;

    public OfforderChecker(String toCheck, boolean onlyMode) {
        wordorders = new ArrayList<>();
        char varType;
        StringBuilder wordOrder = new StringBuilder();
        if(toCheck.startsWith(InputChecker.NOT.toString())) {
            this.isNot = true;
            toCheck = toCheck.substring(1);
        }

        occurance = new Range(toCheck.substring(toCheck.lastIndexOf(InputChecker.QUANTOR.toString())));
        toCheck = toCheck.substring(0, toCheck.lastIndexOf(InputChecker.QUANTOR.toString()));
        toCheck = deleteFirstAndLast("{", "}", toCheck);
        while(toCheck.length() > 0) {

            varType = getFirstChar(toCheck, '\'', '"', '@');
            wordOrder.append(toCheck.substring(0, toCheck.indexOf(varType)+1));
            toCheck = toCheck.substring(toCheck.indexOf(varType)+1);
            wordOrder.append(toCheck.substring(0, toCheck.indexOf(")")+1));
            toCheck = toCheck.substring(toCheck.indexOf(")")+1);
            wordorders.add(new Couple<WordChecker, Range>(new WordChecker(wordOrder.toString()), occurance));
            wordOrder = new StringBuilder();
        }
    }

    public boolean check(List<String> words) {
        boolean result = true;
        int last = words.size();
        List<Couple<WordChecker, Range>> wordorders = new ArrayList<>(this.wordorders);
        Couple<WordChecker, Range> test;

        for(int i=0; i<wordorders.size(); i++) {
            test = wordorders.get(i);
            for(int j=0; j<words.size(); j++) {
                if(test.getSecond().isInRange()) {
                    if(test.getFirst().check(words.get(j))) {
                        test.getSecond().decrease();
                        words.remove(j);
                        if(j<last) {
                            last = j;
                        }
                    }
                } else {
                    break;
                }
            }
            if(test.getSecond().isInRange()) {
                result = false;
            }

        }

        if(onlyMode && last != 0) {
            result = false;
        }

        return result && !isNot;
    }
}
