package com.algos.numbers;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/12/2016
 * Time: 10:02 PM
 */
public class BitwiseProblems {
    public static void main(String[] args) {
        for (int i : new int[]{-2, -1, 1, 2, 3}) {
            System.out.println(i + "(" + BaseConversion.fromDecimal(i, 2) + ") = " + isRightMostBitOne(i));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println("is " + i + " power of 2 = " + isNumberPowerOf2(i));
        }

        for (int i = 0; i < 20; i++) {
            System.out.println("Number of 1 bits in " + i + " = " + getNumberOfOneBits(i));
        }


    }

    /**
     * @param n
     * @return
     */
    private static boolean isRightMostBitOne(int n) {
        //unsigned right shift need to handle negative numbers
        return (n & 1) == 1;
    }

    /**
     * @param n
     * @return
     */
    private static boolean isNumberPowerOf2(int n) {
        //n & (n-1) removes the only 1 bit in the number if n is power of 2
        return n > 1 && (n & (n - 1)) == 0;
    }

    /**
     * Counts the number of 1 bits
     *
     * @param n
     * @return
     */
    private static int getNumberOfOneBits(int n) {
        int count = 0;

        while (n > 0) {
            ++count;
            n = n & (n - 1);
        }

        return count;
    }

    /**
     * Given two integers, m and n, please calculate the number of bits in binary that need to be
     * modified to change m to n. For example, the number 10 is 1010 in binary, and 13 is 1101 in binary. We can
     * modify 3 bits of 1010 to get 1101 in binary.
     */
    private static int bitsToModify(int number1, int number2) {
        // XOR operation gets 1 when two input bits are different and gets 0 when they are same
        int temp = number1 ^ number2;
        //count the 1 bits
        return getNumberOfOneBits(temp);
    }
}
