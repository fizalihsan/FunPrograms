package com.java.collection;

import java.util.*;

/**
 * an algorithm that collapses a list of Iterators into a single Iterator
 * User: Fizal
 * Date: 7/15/2016
 * Time: 3:26 PM
 */
public class MultiIterator<T> implements Iterator<T> {

    private final Iterator<Iterator<T>> listIterator;
    private Iterator<T> currentIterator;

    public MultiIterator(List<Iterator<T>> iterators) {
        this.listIterator = iterators.iterator();
        this.currentIterator = listIterator.next();
    }

    @Override
    public boolean hasNext() {
        if (!currentIterator.hasNext()) {
            if (!listIterator.hasNext()) {
                return false;
            }
            currentIterator = listIterator.next();
            hasNext();
        }
        return true;
    }

    @Override
    public T next() {
        hasNext();
        return currentIterator.next();
    }
    @Override
    public void remove() {
        hasNext();
        currentIterator.remove();
    }

    public static void main(String[] args) {
        final Iterator<Integer> a = Arrays.asList(1, 2, 3, 4, 5).iterator();
        final Iterator<Integer> b = Collections.singletonList(6).iterator();
        final Iterator<Integer> c = new ArrayList<Integer>().iterator();
        final Iterator<Integer> d = new ArrayList<Integer>().iterator();
        final Iterator<Integer> e = Arrays.asList(7, 8, 9).iterator();

        final Iterator<Integer> multiIterator = new MultiIterator<>(Arrays.asList(a, b, c, d, e));

        while(multiIterator.hasNext()){
            System.out.println(multiIterator.next());
        }
    }
}