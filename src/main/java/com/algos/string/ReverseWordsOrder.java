package com.algos.string;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/13/2016
 * Time: 5:08 PM
 */
public class ReverseWordsOrder {
    public static void main(String[] args) {

        System.out.println(reverseWordOrder("hello, how are you doing?"));
    }

    private static String reverseWordOrder(String input){
        StringBuilder result = new StringBuilder();
        int startIndex;
        int endIndex = input.length()-1;

        for (int i = input.length()-1; i >= 0 ; i--) {
            if(input.charAt(i)==' ' || i==0){
                startIndex = i==0?0:i+1;
                char[] array = new char[endIndex - startIndex + 1];
                input.getChars(startIndex, endIndex + 1, array, 0);
                result.append(array).append(" ");
                System.out.println(result);

                endIndex = startIndex - 2;
            }
        }

        return result.toString();
    }

}
