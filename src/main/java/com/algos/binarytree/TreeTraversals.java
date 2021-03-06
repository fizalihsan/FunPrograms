package com.algos.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *                   A
 *              B         C
 *           D     E   F     G
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
        preorder(root); //A, B, D, E, C, F, G,
        System.out.print("\nInorder: ");
        inorder(root); //D, B, E, A, F, C, G,
        System.out.print("\nPostorder: ");
        postorder(root); //D, E, B, F, G, C, A,
        System.out.print("\nBy levels: ");
        levelOrder(root); //D, E, B, F, G, C, A,
    }

    /**
     * Left, Right, Parent
     * @param root
     */
    private static void preorder(Node root) {
        if (root == null) return; // Empty subtree - do nothing
        System.out.print(root.value() + ", "); // Process root node
        preorder(root.left()); // Process all nodes in left
        preorder(root.right()); // Process all nodes in right
    }

    /**
     * Left, Parent, Right
     * @param root
     */
    private static void inorder(Node root) {
        if (root == null) return; // Empty subtree - do nothing
        inorder(root.left()); // Process all nodes in left
        System.out.print(root.value() + ", "); // Process root node
        inorder(root.right()); // Process all nodes in right
    }

    /**
     * Parent, Left, Right
     * @param root
     */
    private static void postorder(Node root) {
        if (root == null) return; // Empty subtree - do nothing
        postorder(root.left()); // Process all nodes in left
        postorder(root.right()); // Process all nodes in right
        System.out.print(root.value() + ", "); // Process root node
    }

    private static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            final Node node = queue.poll();
            System.out.println(node.value());

            if(node.left()!=null){
                queue.add(node.left());
            }

            if(node.right()!=null){
                queue.add(node.right());
            }
        }
    }

}
