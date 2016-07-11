package com.algos.linkedlist;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/17/2016
 * Time: 9:18 PM
 */
public class KthNodeFromEndFinder {

    public static void main(String[] args) {
        Node<Integer> list = new Node<>(1,
                new Node<>(2,
                        new Node<>(3,
                                new Node<>(4,
                                        new Node<>(5,
                                                new Node<>(6,
                                                        new Node<>(7, null)
                                                )
                                        )
                                )
                        )
                )
        );

        final Node<Integer> node = kthNodeFromEnd(list, 3);
        System.out.println(node==null?null:node.value());
    }

    /**
     * Get the Kth node from end of a linked list. It counts from 1 here, so the 1st node from end is the tail of list.
     * For instance, given a linked list with 6 nodes, whose value are 1, 2, 3, 4, 5, 6, its 3rd node from end is the node with value 4
     * Efficiency= O(n)
     *
     * @param head
     * @param k
     * @return If list size is less than k, then null. Else kth node.
     */
    static <T> Node<T> kthNodeFromEnd(Node<T> head, int k) {
        if (head == null) {
            return null;
        }
        Node<T> p1 = head;
        int nodeCount = 0;

        //1. Count the number of nodes in the list
        while (p1 != null) {
            nodeCount++;
            p1 = p1.next();
        }

        //2. If the size is less than k, then return null
        if (nodeCount < k) {
            return null;
        }

        //3. get the (n-len+1)th node from the begining
        p1 = head;
        for (int i = 0; i < (nodeCount - k); i++) {
            p1 = p1.next();
        }

        return p1;
    }
}
