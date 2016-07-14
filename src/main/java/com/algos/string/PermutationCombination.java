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
        String word = "charm";
        System.out.println(" ----------- Permutations -------------");
        permutation(word);
        System.out.println(" ----------- Combinations -------------");
        combination(word);
        System.out.println(" ----------- Combinations 2 -------------");
        combination2(word);
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
     * Prints (2^n)-1 combinations of a given string, where n is the length of the string
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

    /**
     * Combination generation using bit-wise operation. If the input string is 2 characters in length,
     * then 3 (2^2 -1) combinations like 01, 10, 11 are possible.
     *
     * For each combination, print the character at the index where bit is set.
     * @param str
     */
    public static void combination2(String str) {
        count = 0;
        int numberOfBits = str.length();
        int totalCombinations = (int)Math.pow(2, numberOfBits) -1; // 2^n -1

        for (int i = 1; i <= totalCombinations; i++) {
            //convert integer to binary, e.g., 2 = 0010. # of bits depends is equal to the size of the input string
            final String binary = String.format("%"+ str.length() +"s", Integer.toBinaryString(i)).replace(' ', '0');

            System.out.print(++count + ": ");
            for (int j = 0; j < binary.length(); j++) {
                if(binary.charAt(j)=='1'){
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }

    }
}
