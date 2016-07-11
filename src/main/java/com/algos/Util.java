package com.algos;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/11/2016
 * Time: 1:26 PM
 */
public final class Util {

    public static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
