package com.algos.string;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 6/12/2016
 * Time: 3:16 AM
 */
public class Formatting {

    public static void main(String[] args) {
        // String formatting
        System.out.println(String.format("%s", "a"));         //prints 'a'
        System.out.println(String.format("%4s", "a"));        //prints '   a' (using space padding)
        System.out.println(String.format("%2$s", "a", "b"));  //prints 'b' (using argument index)
        System.out.println(String.format("%2$4s", "a", "b")); //prints '   b' (using argument index and space padding)
        System.out.println(String.format("%2$4s", "a", "b")); //prints '   b' (using argument index and space padding)

        System.out.println(new String(new char[5]).replaceAll("\0", "a"));  //prints 'aaaaa' (repeats a given string)
        System.out.println(new String(new char[5]).replaceAll("\0", "ab")); //prints 'ababababab' (repeats a given string)

        // Number formatting
        System.out.println(String.format("%05d", 12)); //prints '00012' (left-padding zeros)
    }
}
