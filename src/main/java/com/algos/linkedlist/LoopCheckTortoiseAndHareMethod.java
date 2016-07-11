package com.algos.linkedlist;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/17/2016
 * Time: 9:52 PM
 */
public class LoopCheckTortoiseAndHareMethod {

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
     * Check if the given list has a loop using Pollard's Rho algorithm which is based on Floyd's algorithm or Tortoise and Hare algorithm.
     * (http://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare)
     * http://en.wikipedia.org/wiki/Pollard%27s_rho_algorithm
     * Efficiency: O(n) time complexity, O(1) space complexity.
     *
     * @param head
     * @return true, if loop exists
     */
    private static <T> boolean hasLoop(Node<T> head){
        if(head==null) return false;

        Node<T> slow = head, fast = head;

        while (fast.next()!=null && fast.next().next()!=null){ // no need to check for slow!=null since fast did that already
            slow = slow.next();
            fast = fast.next().next();

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
