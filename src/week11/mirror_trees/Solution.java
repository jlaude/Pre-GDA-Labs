package week11.mirror_trees;

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

        public void preOrderTraversal () {
            preOrderTraversal(this.root);
        }

        private void preOrderTraversal(Node root) {
            if (root == null) { return;}
            System.out.print(root.data + " ");

            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        public void mirrorTree() {
            BST mirroredBST = new BST();
            mirroredBST.root = mirrorTree(mirroredBST.root, this.root);
            mirroredBST.preOrderTraversal();
        }

        private Node mirrorTree(Node mirroredRoot, Node root){
            if (mirroredRoot == null && root != null) {
                mirroredRoot = new Node();
                mirroredRoot.data = root.data;
            }

            if (root == null) {
                return null;
            }

            if (mirroredRoot.right == null && root.left != null) {
                mirroredRoot.right = mirrorTree(mirroredRoot.right, root.left);
            }
            if (mirroredRoot.left == null && root.right != null) {
                mirroredRoot.left = mirrorTree(mirroredRoot.left, root.right);
            }

            return mirroredRoot;

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

        tree.preOrderTraversal();
        System.out.println();
        tree.mirrorTree();
    }
}
