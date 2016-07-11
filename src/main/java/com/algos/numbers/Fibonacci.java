package com.algos.numbers;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/10/2016
 * Time: 5:32 PM
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Iterative: " + findNthFibIterative(20));
        System.out.println("Recursive: " + findNthFibRecursive(20));
        printFibIterative(5);
    }

    private static void printFibIterative(int n){
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

    /**
     * Efficiency = O(n)
     * @param n
     * @return
     */
    private static long findNthFibIterative(int n){
        if(n <= 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        int x = 0;
        int y = 1;

        for (int i = 2; i < n; i++) {
            int next = x + y;
            x = y;
            y = next;
        }

        return x + y;
    }

    /**
     * Recursive solution has performance issues since it uses additional stack for each call
     * @param n
     * @return
     */
    private static long findNthFibRecursive(int n){
        if(n <= 0){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        return findNthFibRecursive(n-1) + findNthFibRecursive(n-2);
    }
}
