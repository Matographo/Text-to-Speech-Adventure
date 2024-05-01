package de.ttsa.Container;

import de.ttsa.Enums.InputChecker;

public class Range {
    
    private int begin;
    private int end;
    private int current;

    public Range(String string) {
        StringBuilder range = new StringBuilder(string);
        if(range.substring(1,2).matches("\\d")) {
            int ranges = Integer.parseInt(range.substring(1));
            begin = ranges;
            end = ranges;
        } else {
            range.delete(0, 2);
            range.deleteCharAt(range.length()-1);
            String[] rangeArray = range.toString().split(InputChecker.RANGE.toString());
            if(rangeArray[0].equals("")) {
                begin = -1;
            } else {
                begin = Integer.parseInt(rangeArray[0]);
            }

            if(rangeArray.length == 1) {
                end = -1;
            } else {
                end = Integer.parseInt(rangeArray[1]);
            }

            if(this.begin == -1 && this.end == -1) {
                this.begin = 1;
                this.end = 1;
            } else if(this.begin == -1) {
                this.begin = 0;
            } else if(this.end == -1) {
                this.end = Integer.MAX_VALUE;
            }
        }
    }

    public Range() {
        this.begin = 1;
        this.end = 1;
    }

    public void decrease() {
        current--;
    }

    public boolean isInRange() {
        return current > 0;
    }

    @Override
    public String toString() {
        if(begin == end) {
            return "*(" + begin + ")";
        } else {
            return "*(" + begin + "-" + end + ")";
        }
    }

    
}
