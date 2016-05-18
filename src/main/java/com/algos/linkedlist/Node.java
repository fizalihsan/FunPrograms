package com.algos.linkedlist;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/17/2016
 * Time: 9:17 PM
 */
public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" + value + '}';
    }
}
