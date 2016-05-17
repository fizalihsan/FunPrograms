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

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public BSTNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<K, V> left) {
        this.left = left;
    }

    public BSTNode<K, V> getRight() {
        return right;
    }

    public void setRight(BSTNode<K, V> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BSTNode{key=" + key + ", value=" + value + "}";
    }
}
