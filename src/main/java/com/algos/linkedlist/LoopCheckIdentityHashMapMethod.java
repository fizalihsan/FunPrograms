package com.algos.linkedlist;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/17/2016
 * Time: 9:39 PM
 */
public class LoopCheckIdentityHashMapMethod {

    public static void main(String[] args) {
        final Node<Integer> node4 = new Node<>(4);
        final Node<Integer> node3 = new Node<>(3, node4);
        final Node<Integer> node2 = new Node<>(2, node3);
        final Node<Integer> node1 = new Node<>(1, node2);
        node4.next(node1);

        System.out.println(hasLoop(node1));

        Node<Integer> list = new Node<>(1,
                new Node<>(2,
                        new Node<>(3,
                                new Node<>(4, null)
                        )
                )
        );
        System.out.println(hasLoop(list));
    }

    /**
     * Check if the given list has a loop using an IdentityHashMap
     * Complexity: Time = O(n), Space = O(n). Space complexity of this algo is unnecessarily large.
     *
     * @param head
     * @return true, if loop exists
     */
    private static <T> boolean hasLoop(Node<T> head) {
        Map<Node<T>, Node<T>> map = new IdentityHashMap<>();

        Node<T> next = head;
        while (next != null) {
            if (map.containsKey(next)) {
                return true;
            }
            map.put(next, next);
            next = next.next();
        }

        return false;
    }
}
