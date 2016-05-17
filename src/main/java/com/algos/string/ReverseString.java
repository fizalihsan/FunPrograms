package com.algos.string;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/16/2016
 * Time: 6:32 PM
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverse("hello how are you"));
    }

    /**
     * Reverse a string recursively
     */
    private static String reverse(String input){
        if(input==null){
            return null;
        }

        if(input.length()>1){
            final int index = input.length() - 1;
            return input.charAt(index) + reverse(input.substring(0, index));
        }
        return input;
    }
}
