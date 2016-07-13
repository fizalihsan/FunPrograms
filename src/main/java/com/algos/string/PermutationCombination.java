package com.algos.string;

import java.util.Stack;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/11/2016
 * Time: 9:46 PM
 */
public class PermutationCombination {
    public static void main(String[] args) {
//        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String word = "cat";
        System.out.println(" ----------- Permutations -------------");
        permutation(word);
        System.out.println(" ----------- Combinations -------------");
        combination(word);
    }

    /**
     * print n! permutation of the characters of the string s (in order)
     */
    public static void permutation(String s) {
        permutation("", s);
    }

    private static int count = 0;

    private static void permutation(String prefix, String s) {
        if (s.isEmpty()) {
            System.out.println(++count + ": " + prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                final String newPrefix = prefix + s.charAt(i);
                final String newString = s.substring(0, i) + s.substring(i + 1, s.length());
                permutation(newPrefix, newString);
            }
        }
    }

    /**
     *
     * @param str
     */
    private static void combination(String str) {
        count = 0;
        Stack<Character> result = new Stack<>();
        for (int i = 1; i <= str.length(); ++i) {
            combination(str, 0, i, result);
        }
    }

    private static void combination(String str, int index, int number, Stack<Character> result) {
        if (number == 0) {
            System.out.println(++count + ": " + result);
            return;
        }
        if (index == str.length()) {
            return;
        }
        // select the character str[index]
        result.push(str.charAt(index));
        combination(str, index + 1, number - 1, result);
        result.pop();

        // ignore the character str[index]
        combination(str, index + 1, number, result);
    }

}
