package com.algos.queue;

import java.util.Stack;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/16/2016
 * Time: 7:21 PM
 */
public class QueueUsingStacks {
    public static void main(String[] args) {
        OneStackQueue<Integer> queue = new OneStackQueue<>();
        System.out.println(queue.deque());
        queue.enque(1);
        queue.enque(2);
        System.out.println(queue.deque());
        queue.enque(3);
        System.out.println(queue.deque());
        queue.enque(4);
        System.out.println(queue.deque());
        System.out.println(queue.deque());


        TwoStackQueue<Integer> queue2 = new TwoStackQueue<>();
        System.out.println(queue2.deque());
        queue2.enque(1);
        queue2.enque(2);
        System.out.println(queue2.deque());
        queue2.enque(3);
        System.out.println(queue2.deque());
        queue2.enque(4);
        System.out.println(queue2.deque());
        System.out.println(queue2.deque());
    }

    /**
     * Queue implementation using single stack (leverages method call stack as another)
     * 1. Transfer elements from one stack to another temporary stack, to reverse their order.
     * 2. Then push the new element to be inserted, onto the temporary stack
     * 3. Then transfer the elements back to the original stack
     * 4. The new element will be on the bottom of the stack, and the oldest element is on top (first to be popped)
     * @param <T>
     */
    private static class OneStackQueue<T> {
        private final Stack<T> stack = new Stack<>();

        public void enque(T t) {
            if (stack.empty()) {
                stack.push(t);
            } else {
                T topElem = stack.pop();
                enque(t);
                stack.push(topElem);
            }
        }

        public T deque() {
            if(stack.isEmpty()){
                return null;
            }
            return stack.pop();
        }
    }

    /**
     * Queue implementation using 2 stacks
     *
     * enQueue(q)
     * 1) Push element to inbox stack
     *
     * deQueue(q)
     * 1) If both stacks are empty then error.
     * 2) If outbox is empty
     *      push everything from inbox to outbox, until inbox is empty.
     * 3) Pop the element from outbox and return it.
     * @param <T>
     */
    private static class TwoStackQueue<T> {
        private final Stack<T> inbox = new Stack<>();
        private final Stack<T> outbox = new Stack<>();

        public void enque(T t) {
            inbox.push(t);
        }

        public T deque() {
            if (inbox.isEmpty() && outbox.isEmpty()) {
                return null;
            }

            if (outbox.isEmpty()) {
                while (!inbox.isEmpty()) {
                    outbox.push(inbox.pop());
                }
            }
            return outbox.pop();
        }
    }
}
