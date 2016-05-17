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
        list = reverse(list);
        print(list);
    }

    private static <T> Node<T> reverse(Node<T> list){
        if(list == null || list.getNext() == null){
            return list;
        }

        Node<T> n1 = list;
        Node<T> n2 = n1.getNext();

        n1.setNext(null);
        while(n2 != null){
            Node<T> temp = n2.getNext();
            n2.setNext(n1);
            n1 = n2;
            if(temp==null) {
                break;
            }
            n2 = temp;
        }

        return n2;
    }

    private static <T> void print(Node<T> list){
        if(list == null){
            System.out.println("null");
            return;
        }

        Node node = list;
        while(node.getNext()!=null){
            System.out.print(node.getValue() + " -> ");
            node = node.getNext();
        }

        System.out.println("null");
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

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
            return new StringBuilder("Node{").append(value).append(", ").append(next).append('}').toString();
        }
    }
}
