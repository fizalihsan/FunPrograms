package com.algos.sort;

import java.util.Arrays;

/**
 * First, find the smallest item in the array and exchange it with the first entry (itself if the first entry
 * is already the smallest).
 * Then, find the next smallest item and exchange it with the second  entry.
 * Continue in this way until the entire array is sorted.
 *
 * Efficiency
 *   Best: n^2
 *   Average: n^2
 *   Worst: n^2
 *
 * User: Fizal
 * Date: 7/11/2016
 * Time: 1:10 PM
 */
public class SelectionSort<T extends Comparable<T>>{
    public static void main(String[] args) {
        Integer[] nums = {6, 5, 4, 3, 2, 1};
        new SelectionSort<Integer>().sort(nums);
        System.out.println(Arrays.toString(nums));

        String[] strings = {"Q", "U", "I", "C", "K", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        new SelectionSort<String>().sort(strings);
        System.out.println(Arrays.toString(strings));
    }

    private void sort(T[] a) {
        if(a.length == 1){
            return;
        }

        for (int i = 0; i < a.length; i++) {
            //Exchange a[i] with smallest entry in a[i+1...len)
            int min = i; //index of the minimal entry

            for (int j = i+1; j < a.length; j++) {
                if(a[j].compareTo(a[min]) < 0){
                    min = j;
                }
            }

            swap(a, i, min);
        }
    }

    private void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
