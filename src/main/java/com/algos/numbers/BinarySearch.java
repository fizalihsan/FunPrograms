package com.algos.numbers;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/10/2016
 * Time: 5:21 PM
 */
public class BinarySearch {
    public static void main(String[] args) {
        Integer[] nums = {2, 3, 6, 10, 23, 54, 78};

        System.out.println(binarySearch(nums, 23));
    }

    /**
     * Performs the standard binary search.
     * @return index where item is found, or -1 if not found.
     */
    public static <T extends Comparable<? super T>> int binarySearch(T[] a, T x) {
        int low = 0, high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].compareTo(x) < 0) {
                low = mid + 1;
            } else if (a[mid].compareTo(x) > 0) {
                high = mid - 1;
            } else {
                return mid; // Found
            }
        }
        return -1; //Not found
    }
}
