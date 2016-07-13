package com.algos.linkedlist;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 7/12/2016
 * Time: 11:13 PM
 */
public class DeleteDuplicatesFromSortedList {

    public static void main(String[] args) {

        Node<Integer> list = new Node<>(1,
                new Node<>(2,
                        new Node<>(3,
                                new Node<>(3,
                                        new Node<>(3,
                                                new Node<>(4,
                                                        new Node<>(4, null)
                                                )
                                        )
                                )
                        )
                )
        );

        deleteDuplicates(list);

        while (list != null) {
            System.out.println(list.value());
            list = list.next();
        }
    }

    private static void deleteDuplicates(Node<Integer> node) {
        if (node == null) {
            return;
        }

        Node<Integer> previous = null;

        while (node != null) {
            if (previous != null && node.value().equals(previous.value())) {
                previous.next(node.next());
            } else {
                previous = node;
            }
            node = node.next();
        }

    }
}
