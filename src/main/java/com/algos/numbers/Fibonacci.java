package com.algos.numbers;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/10/2016
 * Time: 5:32 PM
 */
public class Fibonacci {
    public static void main(String[] args) {
        printnFibonacci(50);
    }

    private static void printnFibonacci(int n){
        int x = 0;
        int y = 1;

        System.out.println(x);
        System.out.println(y);

        for (int i = 0; i < n; i++) {
            int temp = x;
            x = y;
            y = temp + y;
            System.out.println(y);
        }
    }
}
