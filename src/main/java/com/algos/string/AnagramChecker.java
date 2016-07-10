package com.algos.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given 2 strings, this program checks if they are anagrams
 *
 * User: Fizal
 * Date: 6/12/2016
 * Time: 1:48 AM
 */
public class AnagramChecker {

    private static final Map<Character, Integer> PRIME_MAP = new HashMap<>();

    public static void main(String[] args) {
        System.out.println( isAnagramUsingPrimeMap("god", "Dog"));
        System.out.println( isAnagramUsingPrimeMap("god ", "Dog "));
        System.out.println( isAnagramUsingPrimeMap("good ", "Dog "));
        System.out.println( isAnagramUsingPrimeMap("silent", "listen"));
    }

    /**
     * Assign a prime value to each alphabet. Multiply the prime value of each character from both strings.
     * As per prime factorization, the numbers should match if they are anagrams
     *
     * Efficiency: O(n)
     * @param str1
     * @param str2
     * @return
     */
    private static boolean isAnagramUsingPrimeMap(String str1, String str2){
        if(str1 == null || str2 == null || str1.length()!=str2.length()){
            return false;
        }

        return findPrimeValue(str1.trim().toLowerCase()) == findPrimeValue(str2.trim().toLowerCase());
    }

    private static long findPrimeValue(String str){
        long primeValue = 1;

        for (int i = 0; i < str.length(); i++) {
            primeValue *= PRIME_MAP.get(str.charAt(i));
        }

        return primeValue;
    }

    static {
        PRIME_MAP.put('a', 2);
        PRIME_MAP.put('b', 3);
        PRIME_MAP.put('c', 5);
        PRIME_MAP.put('d', 7);
        PRIME_MAP.put('e', 11);
        PRIME_MAP.put('f', 13);
        PRIME_MAP.put('g', 17);
        PRIME_MAP.put('h', 19);
        PRIME_MAP.put('i', 23);
        PRIME_MAP.put('j', 29);
        PRIME_MAP.put('k', 31);
        PRIME_MAP.put('l', 37);
        PRIME_MAP.put('m', 41);
        PRIME_MAP.put('n', 43);
        PRIME_MAP.put('o', 47);
        PRIME_MAP.put('p', 53);
        PRIME_MAP.put('q', 59);
        PRIME_MAP.put('r', 61);
        PRIME_MAP.put('s', 67);
        PRIME_MAP.put('t', 71);
        PRIME_MAP.put('u', 73);
        PRIME_MAP.put('v', 79);
        PRIME_MAP.put('w', 83);
        PRIME_MAP.put('x', 89);
        PRIME_MAP.put('y', 97);
        PRIME_MAP.put('z', 101);
    }

}
