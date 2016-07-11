package com.algos.binarytree;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/16/2016
 * Time: 8:15 AM
 */
public class BinarySearchTreeChecker {
    public static void main(String[] args) {
        Node<Integer> bsTree =
                new Node<>(6,
                        new Node<>(4,
                                new Node<>(2, new Node<>(1), new Node<>(3)),
                                new Node<>(5)
                        ),
                        new Node<>(9,
                                new Node<>(8, new Node<>(7), null),
                                new Node<>(10)
                        )
                );

        Node<Integer> nonBsTree =
                new Node<>(6,
                        new Node<>(9,
                                new Node<>(2, new Node<>(1), new Node<>(3)),
                                new Node<>(5)
                        ),
                        new Node<>(4,
                                new Node<>(8, new Node<>(7), null),
                                new Node<>(10)
                        )
                );

        System.out.println("Tree1 is BST? : " + checkBST(bsTree)); // true
        System.out.println("Tree2 is BST? : " + checkBST(nonBsTree)); // false
        System.out.println("Tree1 is BST, within 1 & 10? : " + checkBST(bsTree, 1, 10)); // true
        System.out.println("Tree1 is BST, within 1 & 7? : " + checkBST(bsTree, 1, 7)); // false
        System.out.println("Tree2 is BST, within 1 & 10? : " + checkBST(nonBsTree, 1, 10)); // false
    }

    /**
     * Checks if the given tree is a BST + validates if the values are within the given legal range.
     * low & high dictates what range of values are legal for the given node
     */
    private static boolean checkBST(Node<Integer> root, int low, int high) {
        if (root == null) return true; // Empty subtree

        int rootkey = root.value();

        if (rootkey < low || rootkey > high) {
            return false; // Out of range
        }

        return checkBST(root.left(), low, rootkey) && checkBST(root.right(), rootkey, high);

    }

    /**
     * Just checks if the given tree is a BST
     */
    private static boolean checkBST(Node<Integer> root) {
        if (root == null) return true; // Empty subtree

        int rootValue = root.value();

        if (root.left() != null && root.left().value() > rootValue) { // check left child, if exists
            return false;
        }

        if (root.right() != null && rootValue > root.right().value()) { // check right, if exists
            return false;
        }

        return checkBST(root.left()) && checkBST(root.right());

    }
}
