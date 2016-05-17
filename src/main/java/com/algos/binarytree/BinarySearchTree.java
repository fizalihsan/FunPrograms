package com.algos.binarytree;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/17/2016
 * Time: 6:14 AM
 */
public class BinarySearchTree<K extends Comparable<? super K>, V> {
    private BSTNode<K, V> root;
    private int size = 0;

    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
        tree.put(37, 37);
        tree.put(24, 24);
        tree.put(32, 32);
    }

    public V get(Object key) {
        return null;
    }

    public V put(K key, V value) {
        root = putHelp(root, key, value);
        size++;
        return value;
    }

    public BSTNode<K, V> putHelp(BSTNode<K, V> node, K key, V value){
        if(node == null){
            return new BSTNode<>(key, value);
        }

        if(node.getKey().compareTo(key) > 0){
            final BSTNode<K, V> left = putHelp(node.getLeft(), key, value);
            node.setLeft(left);
        } else if(node.getKey().compareTo(key) < 0) {
            final BSTNode<K, V> right = putHelp(node.getRight(), key, value);
            node.setRight(right);
        }
        return node;
    }

    public V remove(Object key) {
        return null;
    }

    public void clear() {
        root = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
