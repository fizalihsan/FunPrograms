package com.algos.array;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/17/2016
 * Time: 9:12 AM
 */
public class SecondHighestNumber {
    public static void main(String[] args) {
        System.out.println(findSecondHighest(new int[]{-6, -3, -4, -2, -1, -5}));
    }

    private static int findSecondHighest(int[] nums){
        int firstHighest = Integer.MIN_VALUE, secondHighest = Integer.MIN_VALUE;

        for (int num : nums) {
            if(num > firstHighest){
                secondHighest = firstHighest;
                firstHighest = num;
            } else if(num > secondHighest){
                secondHighest = num;
            }
        }

        return secondHighest;
    }
}
