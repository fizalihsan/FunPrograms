package com.algos.binarytree;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/17/2016
 * Time: 6:27 AM
 */
public class BSTNode<K extends Comparable<? super K>, V> {
    private K key;
    private V value;
    private BSTNode<K, V> left;
    private BSTNode<K, V> right;

    public BSTNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public BSTNode(K key, V value, BSTNode<K, V> left, BSTNode<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public K key() {
        return key;
    }

    public void key(K key) {
        this.key = key;
    }

    public V value() {
        return value;
    }

    public void value(V value) {
        this.value = value;
    }

    public BSTNode<K, V> left() {
        return left;
    }

    public void left(BSTNode<K, V> left) {
        this.left = left;
    }

    public BSTNode<K, V> right() {
        return right;
    }

    public void right(BSTNode<K, V> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode{key=" + key + ", value=" + value + "}";
    }
}
