package sequencecommune;

import static java.lang.Integer.max;

public class LongestCommonSubsequence<T> {
    protected T[] firstSequence;

    protected T[] secondSequence;

    public LongestCommonSubsequence(T[] firstSequence, T[] secondSequence) {
        this.firstSequence = firstSequence;
        this.secondSequence = secondSequence;
    }

    //@ public normal_behaviour
    //@ requires longFirst ==  0 ||  longSecond ==  0;
    //@ ensures \result ==  0;
    //@ also
    //@ public normal_behaviour
    //@ requires 0 < longFirst &&  longFirst < firstSequence.length;
    //@ requires 0 < longSecond &&  longSecond < secondSequence.length;
    //@ requires firstSequence[longFirst-1].equals(secondSequence[longSecond-1]);
    //@ ensures \result ==  longestSize(longFirst - 1, longSecond - 1)
    //@ public normal_behaviour
    //@ requires 0 < longFirst &&  longFirst < firstSequence.length;
    //@ requires 0 < longSecond &&  longSecond < secondSequence.length;
    //@ requires ! firstSequence[longFirst-1].equals(secondSequence[longSecond-1]);
    //@ ensures \result ==  longestSize(longFirst - 1, longSecond - 1)
    //@ decreasing longFirst + longSecond;
    public /**@ pure **/ int longestSize(int longFirst, int longSecond) {
        if (longFirst ==  0 ||  longSecond ==  0) {
            return 0;
        }

        if (firstSequence[longFirst-1].equals(secondSequence[longSecond-1])) {
            return longestSize(longFirst - 1, longSecond - 1) + 1;
        }

        return max(longestSize(longFirst - 1, longSecond), longestSize(longFirst, longSecond - 1));
    }

    public int longestSize() {
        return longestSize(firstSequence.length, secondSequence.length);
    }


}
