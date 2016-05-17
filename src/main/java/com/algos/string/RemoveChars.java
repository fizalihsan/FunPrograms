package com.algos.string;

import java.util.HashSet;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/13/2016
 * Time: 4:55 PM
 */
public class RemoveChars {
    public static void main(String[] args) {
        System.out.println(removeChars("fizalihsan", "aeiou"));
    }

    /**
     * Efficiency = O(2n) which is O(n)
     * @param str
     * @param charsToRemove
     * @return
     */
    private static String removeChars(String str, String charsToRemove){
        HashSet<Character> remove = new HashSet<>();
        //1st loop - O(n)
        for (char c : charsToRemove.toCharArray()) {
            remove.add(c);
        }


        StringBuilder newStr = new StringBuilder();
        //2nd loop - O(n)
        for (char c : str.toCharArray()) {
            if(!remove.contains(c)){
                newStr.append(c);
            }
        }

        return newStr.toString();
    }
}
