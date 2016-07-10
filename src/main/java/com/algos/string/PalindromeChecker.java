package com.algos.string;

import java.util.Scanner;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/10/2016
 * Time: 5:14 PM
 */
public class PalindromeChecker {

    public static void main(String[] args) {
//      Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.
        for (String s : readInput()) {
            System.out.println(palindromeChecker(s));
        }
    }

    private static int palindromeChecker(String s){
        int i = 0;
        int j = s.length() - 1;

        while(i < s.length()/2){
            if(s.charAt(i) != s.charAt(j)){
                return i;
            }
        }

        return -1;
    }

    private static String[] readInput(){
        Scanner scanner = new Scanner(System.in);

        final int n = scanner.nextInt();
        if(n<1){
            throw new RuntimeException("Input cannot be less than 1");
        }

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        return arr;
    }
}
