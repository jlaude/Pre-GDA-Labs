package week11.lowest_common_ancestor;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
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

        public void lowestCommonAncestor (int v, int w) {

            System.out.print(lowestCommonAncestor(v,w,this.root).data);
        }

        private Node lowestCommonAncestor (int v, int w,  Node root) {

            if (root == null) {
                return null;
            }

            if (v < root.data && w < root.data) {
                return lowestCommonAncestor(v, w, root.left);
            } else if ( v > root.data && w > root.data) {
                return lowestCommonAncestor(v, w, root.right);
            }

            return root;


        }

    }


    public static void main(String[] args) {

        /*
        Input:
        7 1 9
        5
        2
        8
        1
        3
        6
        9

        Tree:

                 5
            2        8
         1    3   6     9

         Output:
         5

        */

        Scanner in = new Scanner(System.in);
        int treeSize = in.nextInt();
        int v = in.nextInt();
        int w = in.nextInt();
        BST tree = new BST();
        for (int i = 0; i < treeSize; i++) {
            in.nextLine();
            tree.insert(in.nextInt());
        }

        tree.lowestCommonAncestor(v, w);

    }
}