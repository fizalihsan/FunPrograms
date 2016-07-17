package com.algos.linkedlist;

/**
 * Reverse a singly linked list iteratively
 */
public class ReverseSinglyLinkedList {
    public static void main(String[] args) {

        Node<Integer> list = new Node<>(1,
                new Node<>(2,
                        new Node<>(3,
                                new Node<>(4, null)
                        )
                )
        );

        print(list);
        Node<Integer> reversed = reverse(list);
        print(reversed);

        list = new Node<>(1,
                new Node<>(2,
                        new Node<>(3,
                                new Node<>(4, null)
                        )
                )
        );
        reversed = reverse2(list);
        print(reversed);
    }

    /**
     * Reverses the given singly-linked list.
     * Complexity: Time = O(n), Space = O(1)
     * @param node
     * @return Head of the reversed node
     */
    private static <T> Node<T> reverse(Node<T> node) {
        if (node == null || node.next() == null) {
            return node;
        }

        Node<T> n1 = node;
        Node<T> n2 = n1.next();

        n1.next(null);
        while (n2 != null) {
            Node<T> temp = n2.next();
            n2.next(n1);
            n1 = n2;
            if (temp == null) {
                break;
            }
            n2 = temp;
        }

        return n2;
    }

    /**
     * Recursive version of reversing a singly-linked list
     * @param original
     * @param <T>
     * @return
     */
    public static <T> Node<T> reverse2(final Node<T> original) {
        if (original == null) {
            throw new NullPointerException("Cannot reverse a null list");
        }
        if(original.next() == null) {
            return original;
        }
        final Node<T> next = original.next();
        original.next(null);
        final Node<T> othersReversed = reverse(next);
        next.next(original);
        return othersReversed;
    }

    private static <T> void print(Node<T> list) {
        if (list == null) {
            System.out.println("null");
            return;
        }

        Node node = list;
        while (node != null) {
            System.out.print(node.value() + " -> ");
            node = node.next();
        }

        System.out.println("null");
    }
}
