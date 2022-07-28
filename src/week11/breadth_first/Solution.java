package week11.breadth_first;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

        public void breadthFirstTraversal () {
            breadthFirstTraversal(this.root);
        }

        private void breadthFirstTraversal(Node root) {

            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {

                Node n = queue.remove();
                System.out.print (n.data + " ");

                if (n.left != null) {
                    queue.add(n.left);
                }
                if (n.right != null) {
                    queue.add(n.right);
                }
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

        tree.breadthFirstTraversal();


    }
}