package com.algos.linkedlist;

/**
 * 1. Reverse the list and print. Cons: structure is modified
 * 2. Add elements to stack and print. Cons: additional data structure is needed
 * 3. Use recursion
 * User: Fizal
 * Date: 7/10/2016
 * Time: 6:48 PM
 */
public class PrintFromTailToEnd {
    public static void main(String[] args) {

        Node<Integer> list = new Node<>(1,
                new Node<>(2,
                        new Node<>(3,
                                new Node<>(4, null)
                        )
                )
        );

        printUsingRecursion(list);
    }

    private static void printUsingRecursion(Node node){
        if(node.next()!=null){
            printUsingRecursion(node.next());
        }
        System.out.println(node.value());
    }
}
