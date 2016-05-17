package com.algos.binarytree;

/**
 * Comment here about the class
 * User: Fizal
 * Date: 5/16/2016
 * Time: 7:56 AM
 */
public class TreeTraversals {
    public static void main(String[] args) {
        Node<String> root =
                new Node<>("A",
                        new Node<>("B",
                                new Node<>("D"), new Node<>("E")
                        ),
                        new Node<>("C",
                                new Node<>("F"), new Node<>("G")
                        )
                );

        System.out.print("\nPreorder: ");
        preorder(root);
        System.out.print("\nInorder: ");
        inorder(root);
        System.out.print("\nPostorder: ");
        postorder(root);
    }

    private static void preorder(Node root) {
        if (root == null) return; // Empty subtree - do nothing
        System.out.print(root.getValue() + ", "); // Process root node
        preorder(root.getLeft()); // Process all nodes in left
        preorder(root.getRight()); // Process all nodes in right
    }

    private static void inorder(Node root) {
        if (root == null) return; // Empty subtree - do nothing
        inorder(root.getLeft()); // Process all nodes in left
        System.out.print(root.getValue() + ", "); // Process root node
        inorder(root.getRight()); // Process all nodes in right
    }

    private static void postorder(Node root) {
        if (root == null) return; // Empty subtree - do nothing
        postorder(root.getLeft()); // Process all nodes in left
        postorder(root.getRight()); // Process all nodes in right
        System.out.print(root.getValue() + ", "); // Process root node
    }
}
