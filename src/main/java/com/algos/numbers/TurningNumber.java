package com.algos.numbers;

/**
 * A turning number is the maximum number in a unimodal array that increases and then decreases.
 * This program finds the index of the turning number in a unimodal array.
 *
 * User: Fizal
 * Date: 7/11/2016
 * Time: 2:26 PM
 */
public class TurningNumber {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
        int[] nums = {1, 3, 2};

        final int turningIndex = getTurningIndex(nums);
        System.out.println("Turning index: " + turningIndex + " - Value: " + nums[turningIndex]);
    }

    /**
     * Same approach as binary search is used
     * @param a
     * @return
     */
    private static int getTurningIndex(int a[]) {
        if (a.length <= 2)
            return -1;

        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo + 1) {
            int mid = (lo + hi) / 2;
            if (mid == 0 || mid == a.length - 1)
                return -1;

            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                return mid;
            } else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1]) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return -1;
    }
}
