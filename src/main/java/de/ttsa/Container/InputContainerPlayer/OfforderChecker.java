package de.ttsa.Container.InputContainerPlayer;

import java.util.List;
import java.util.ArrayList;

import de.ttsa.Container.Couple;
import de.ttsa.Container.Range;
import de.ttsa.Container.Triple;
import de.ttsa.Enums.InputChecker;
import de.ttsa.Parents.StringMethods;

public class OfforderChecker extends StringMethods {
    
    private List<WordChecker> wordorders;
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
            wordorders.add(new WordChecker(wordOrder.toString()));
            wordOrder = new StringBuilder();
        }
    }

    public boolean check(List<String> words) {
        boolean result = true;
        int last = words.size();
        List<WordChecker> wordorders = new ArrayList<>(this.wordorders);
        WordChecker test;

        for(int i=0; i<wordorders.size(); i++) {
            test = wordorders.get(i);
            for(int j=0; j<words.size(); j++) {
                if(test.getRange().doesNotReachEnd()) {
                    if(test.check(words.get(j))) {
                        test.getRange().increase();
                        words.remove(j);
                        if(j<last) {
                            last = j;
                        }
                    }
                } else {
                    break;
                }
            }
            if(!test.getRange().isInRange()) {
                result = false;
            }

        }

        if(onlyMode && last != 0) {
            result = false;
        }

        return result && !isNot;
    }
}
