package com.algos.binarytree;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/16/2016
 * Time: 7:53 AM
 */
public class Node<E> {
    private E value;
    private Node<E> left;
    private Node<E> right;

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> left, Node<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public E value() {
        return value;
    }

    public Node<E> left() {
        return left;
    }

    public Node<E> right() {
        return right;
    }

    public void value(E value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
