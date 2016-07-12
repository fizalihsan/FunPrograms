package com.algos.string;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/11/2016
 * Time: 9:46 PM
 */
public class Permutations {
    public static void main(String[] args) {
//        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String word = "cat";
        perm1(word);
//        System.out.println();
//        perm2(word);
    }

    // print n! permutation of the characters of the string s (in order)
    public static void perm1(String s) {
        perm1("", s);
    }

    private static int count = 0;

    private static void perm1(String prefix, String s) {
        if (s.isEmpty()) {
            System.out.println(++count + ": " + prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                final String newPrefix = prefix + s.charAt(i);
                final String newString = s.substring(0, i) + s.substring(i + 1, s.length());
                perm1(newPrefix, newString);
            }
        }
    }

    /*// print n! permutation of the elements of array a (not in order)
    public static void perm2(String s) {
        int n = s.length();
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i);
        }
        perm2(a, n);
    }

    private static void perm2(char[] a, int n) {
        if (n == 1) {
            System.out.println(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            perm2(a, n - 1);
            swap(a, i, n - 1);
        }
    }


    // swap the characters at indices i and j
    private static void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }*/
}
