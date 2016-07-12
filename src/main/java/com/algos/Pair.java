package com.algos;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/11/2016
 * Time: 8:22 PM
 */
public class Pair<T> {
    private T one, two;

    public Pair(T one, T two) {
        this.one = one;
        this.two = two;
    }

    public T one() {
        return one;
    }

    public T two() {
        return two;
    }
}
