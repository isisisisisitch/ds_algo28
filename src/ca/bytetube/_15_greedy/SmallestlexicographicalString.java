package ca.bytetube._15_greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Basic rule:
 * Given two strings s1 and s2:
 * 1. start from the first character and compare the corresponding characters of the two strings one by one.
 * 2.comparison rule:
 * if s1[i] < s2[i] ->s1 is less than s2
 * if s1[i] > s2[i] ->s1 is greater than s2
 * if s1[i] = s2[i] ->compare the next character
 * <p>
 * 3.if the comparison reaches the end of one of the strings:
 * the shorter string is considered smaller
 * “abc” < “abcd”
 * <p>
 * “ab” < “b”
 * “ab” > “a”
 */
public class SmallestlexicographicalString {
    public static void main(String[] args) {
        String[] strs = {"ba","ab"};
        System.out.println(smallestlexicographicalString(strs));
    }


    public static String smallestlexicographicalString(String[] strs) {
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
}
