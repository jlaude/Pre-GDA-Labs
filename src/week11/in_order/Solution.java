package week11.in_order;

import java.util.Scanner;

public class Solution {

    public static class Node {
        Node left;
        Node right;
        int data;
    }

    public static class BST {
        Node root;

        public  void insert (int data) {
            root = insert(this.root, data);
        }

        private Node insert (Node root, int data) {
            if (root == null) {
                root = new Node();
                root.data = data;
            } else if (data < root.data) {
                root.left = insert(root.left, data);
            } else if (data > root.data) {
                root.right =insert(root.right, data);
            }
            return root;
        }

        public void inOrderTraversal () {
            inOrderTraversal(this.root);
        }

        private void inOrderTraversal(Node root) {
            if (root == null) {
                return;
            } else {
                inOrderTraversal(root.left);
                System.out.print(root.data + " ");
                inOrderTraversal(root.right);
            }
        }

    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int treeSize = in.nextInt();
        BST tree = new BST();
        for (int i = 0; i < treeSize; i++) {
            in.nextLine();
            tree.insert(in.nextInt());
        }

        tree.inOrderTraversal();

    }
}