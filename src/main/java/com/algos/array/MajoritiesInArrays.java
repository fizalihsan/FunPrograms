package com.algos.array;

/**
 * Find the majority element in an array that occurs for more than half of the size of the array.
 * For example, the number 2 in the array {1, 2, 3, 2, 2, 2, 5, 4, 2} is the majority element because it appears five
 * times and the size of the array is 9.
 *
 * User: Fizal
 * Date: 7/11/2016
 * Time: 5:34 PM
 */
public class MajoritiesInArrays {
    public static void main(String[] args) {
        System.out.println(new MajoritiesInArrays().getMajority_2(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    private int getMajority_2(int[] numbers) {
        int result = numbers[0];
        int times = 1;
        for (int i = 1; i < numbers.length; ++i) {
            if (times == 0) {
                result = numbers[i];
                times = 1;
            } else if (numbers[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        if (!isResultValid(numbers, result)) throw new IllegalArgumentException("No majority exisits.");
        return result;
    }

    private boolean isResultValid(int[] numbers, int number) {
        int times = 0;
        for(int i = 0; i < numbers.length; ++i) {
            if(numbers[i] == number)
                times++;
        }
        return (times * 2 > numbers.length);
    }
}
