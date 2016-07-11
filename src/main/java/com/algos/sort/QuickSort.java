package com.algos.sort;

import java.util.Arrays;
import java.util.Random;

import static com.algos.Util.swap;

/**
 *
 * Efficiency
 *   Best: nlogn
 *   Average: nlogn
 *   Worst: n^2
 *
 * Pros
 * > Uses a small auxillary stack (via recursion)
 *
 * Cons
 * > if the pivot chose is 'lo' every time, then only one exchange happens on the right sub-array
 *   instead of 2 on both sub-arrays. This could be avoided by picking random pivot
 * > Mistakes would lead to quadratic performance
 * > Quick sort is slower than Insertion sort for smaller arrays. Practically, if the quick sort's
 *   sub-array is below a certain size, use insertion sort, else quick sort.
 *
 * User: Fizal
 * Date: 7/11/2016
 * Time: 2:48 AM
 */
public class QuickSort<T extends Comparable<T>> {
    public static void main(String[] args) {
        Integer[] nums = {6, 5, 4, 3, 2, 1};
        new QuickSort<Integer>().sort(nums);
        System.out.println(Arrays.toString(nums));

        String[] strings = {"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        new QuickSort<String>().sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    private void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(T[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot = partition(arr, lo, hi);
        sort(arr, lo, pivot - 1);
        sort(arr, pivot + 1, hi);
    }

    /**
     * This is the crux of the process, which rearranges the array to make the following three conditions hold:
     * 1. The entry a[j] is in its final place in the array, for some j.
     * 2. No entry in a[lo] through a[j-1] is greater than a[j].
     * 3. No entry in a[j+1] through a[hi] is less than a[j].
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private int partition(T[] a, int lo, int hi) {
        T pivot = a[lo];//partitioning item

        //Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo; //left scan index
        int j = hi + 1; //right scan index

        while (true) {
            //Scan left till end or until an element lesser than pivot is found
            while (a[++i].compareTo(pivot) < 0 && i != hi);

            //Scan right till start or until an element greater than pivot is found
            while (pivot.compareTo(a[--j]) < 0 && j != lo);

            //check for scan complete and swap
            if(i>=j) break;
            swap(a, i, j);
        }

        swap(a, lo, j); // Put 'partitioning' item into the a[j] position
        return j;
    }

    /**
     * This implementation is from "Coding Algorithms" book. It uses a single loop instead of 3.
     *
     * Need to understand how it works.
     * @param arr
     * @param lo
     * @param hi
     * @return
     */
    private int partition2(T[] arr, int lo, int hi) {
        // "+ 1" is to staying in bounds. If the random number chosen is 0, 'small' would go negative
        // picking a random pivot is crucial for the predicatability of the algorithm
        int pivot = lo + new Random().nextInt(hi - lo + 1);

        swap(arr, pivot, hi);

        int small = lo - 1;

        for (int i = lo; i <= hi; i++) {
            if (arr[i].compareTo(arr[hi]) < 0) { //arr[i] < arr[hi]
                ++small;
                if (i != small) {
                    swap(arr, small, i);
                }
            }
        }

        ++small;
        if (small != hi) {
            swap(arr, small, hi);
        }
        return small;
    }

}
