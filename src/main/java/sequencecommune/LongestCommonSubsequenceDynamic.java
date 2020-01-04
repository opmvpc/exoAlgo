package sequencecommune;

import java.util.Arrays;

import static java.lang.Integer.max;

public class LongestCommonSubsequenceDynamic<T> extends LongestCommonSubsequence<T> {
    private Integer[][] cache;

    private Case[][] caseCache;

    private enum Case {case1, case2, case3}; // 3 cas récursifs possibles

    public LongestCommonSubsequenceDynamic(T[] firstSequence, T[] secondSequence) {
        super(firstSequence, secondSequence);
        this.cache = new Integer[firstSequence.length + 1][secondSequence.length + 1];
        this.caseCache = new Case[firstSequence.length+1][secondSequence.length+1];
    }

    @Override
    public int longestSize() {
        int longestSize = longestSize(firstSequence.length, secondSequence.length);

        for (int i = 0; i < firstSequence.length; i++) {
            for (int j = 0; j < secondSequence.length; j++) {
                if (caseCache[i][j] !=  null &&  caseCache[i][j].equals(Case.case2)) {
                    System.out.print(firstSequence[i]);
                }
            }
        }

        return longestSize;
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
    //@ decreasing longFirst * longSecond;
    @Override
    public /**@ pure **/ int longestSize(int longFirst, int longSecond) {
        if (longFirst ==  0 ||  longSecond ==  0) {
            caseCache[longFirst][longSecond] = Case.case1;
            return 0;
        }

        if (firstSequence[longFirst-1].equals(secondSequence[longSecond-1])) {
            return longestSizeProxy(longFirst - 1, longSecond - 1, Case.case2) + 1;
        }

        return max(longestSizeProxy(longFirst - 1, longSecond, Case.case3), longestSizeProxy(longFirst, longSecond - 1, Case.case3));
    }

    //@ public normal_behaviour
    //@ requires longFirst >= 0 &&  longFirst < firstSequence.length;
    //@ requires longSecond >= 0 &&  longSecond < secondSequence.length;
    //@ modifies this;
    //@ ensures \old(cache[longFirst][longSecond]) ==  null ==>   cache[longFirst][longSecond] ==  longestSize(longFirst, longSecond);
    //@ ensures \old(caseCache[longFirst-1][longSecond-1]) ==  null ==>   caseCache[longFirst-1][longSecond-1] ==  aCase);
    //@ ensures \result ==  longestSize(longFirst, longSecond);
    private int longestSizeProxy(int longFirst, int longSecond, Case aCase) {
        if (longFirst >= 0 &&  longSecond >= 0 &&  caseCache[longFirst][longSecond] ==  null) {
            caseCache[longFirst][longSecond] = aCase;
        }

        if (cache[longFirst][longSecond] !=  null) {
            return cache[longFirst][longSecond];
        }

        cache[longFirst][longSecond] = longestSize(longFirst, longSecond);
        return cache[longFirst][longSecond];
    }
}
