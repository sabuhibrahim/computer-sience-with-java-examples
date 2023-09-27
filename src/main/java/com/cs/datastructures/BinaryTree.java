package com.cs.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private class Node implements Comparable<BinaryTree.Node> {
        Integer value;
        Node left;
        Node right;


        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }


        void print() {
            print("", this, false);
        }
    
        void print(String prefix, Node n, boolean isLeft) {
            if (n != null) {
                System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
                print(prefix + (isLeft ? "|   " : "    "), n.left, true);
                print(prefix + (isLeft ? "|   " : "    "), n.right, false);
            }
        }

        public int compareTo(Node node) {
            return this.value.compareTo(node.value);
        };


    }

    private Node root;

    public BinaryTree() {

    }

    private Node addRecursive(Node node, int value) {
        if(node == null) {
            return new Node(value);
        }
        if( value < node.value) {
            node.left = addRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = addRecursive(node.right, value);
        } else {
            //
        }

        return node;
    }

    

    public void add(int value){
        root = addRecursive(root, value);
    }

    private boolean containRecursive(Node node, int value) {

        if (node == null) {
            return false;
        }else if (node.value == value) {
            return true;
        } else if(node.value > value) {
            return containRecursive(node.left, value);
        } else { // node.value < value
            return containRecursive(node.right, value);
        }
    }

    public boolean contain(int value){
        return containRecursive(root, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if(node == null) {
            return null;
        }

        if(node.value == value) {
            if(node.left == null && node.right == null) {
                return null;
            } else if(node.left != null && node.right == null) {
                return node.left;
            } else if(node.left == null && node.right != null) {
                return node.right;
            } else {
                return addRight(node.left, node.right);
            }
        }else if(node.value > value){
            node.left = deleteRecursive(node.left, value);
        } else {
            node.right = deleteRecursive(node.right, value);
        }

        return node;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node addRight(Node node, Node newNode) {
        if(node == null) {
            return newNode;
        }
        node.right = addRight(node.right, newNode);
        return node;
    }


    public void print() {

        System.out.print("\nLevelOrder: ");
        printLevelOrder();
        System.out.print("\nPreOrder: ");
        printPreOrder(root);
        System.out.print("\nInOrder: ");
        printInOrder(root);
        System.out.print("\nPostOrder: ");
        printPostOrder(root);
    }

    public void printPreOrder(Node node) {
        System.out.print(node.value + " ");

        if(node.left != null) {
            printPreOrder(node.left);
        }
        if(node.right != null) {
            printPreOrder(node.right);
        }
    }

    public void printInOrder(Node node) {

        if(node.left != null) {
            printInOrder(node.left);
        }

        System.out.print(node.value + " ");

        if(node.right != null) {
            printInOrder(node.right);
        }
    }

    public void printPostOrder(Node node) {

        if(node.left != null) {
            printPostOrder(node.left);
        }

        if(node.right != null) {
            printPostOrder(node.right);
        }

        System.out.print(node.value + " ");
    }

    public void printLevelOrder() {
        if (root == null) {
            return;
        }

        // with using queue
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(root);

        while(!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.value + " ");
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }


    };

    private void printLevelOrderNode(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 0){
            System.out.print(node.value + " ");
        } else if(level > 0){
            printLevelOrderNode(node.left, level - 1);
            printLevelOrderNode(node.right, level - 1);
        }
    };


    public void printTree() {
        if (root != null) {
            root.print("", root, false);
        }
    }

    public int max() throws Exception {
        if (root == null) {
            throw new Exception("Binary Tree is empty.");
        }

        Node maxNode = findMax(root);

        return maxNode.value;
    }


    private Node findMax(Node node) {
        if (node.right != null) {
            return findMax(node.right);
        }

        return node;
    }


    public int min() throws Exception {
        if (root == null) {
            throw new Exception("Binary Tree is empty.");
        }

        Node minNode = findMin(root);
        
        return minNode.value;
    }

    private Node findMin(Node node) {
        if(node.left != null) return findMin(node.left);

        return node;
    }


    public int height() {
        if (root == null) return 0;
        return calculateHeight(root);
    }


    private int calculateHeight(Node node) {
        int r = 0;
        int l = 0;
        if (node.right != null) {
            r = 1 + calculateHeight(node.right);
        }

        if(node.left != null) {
            l = 1 + calculateHeight(node.left);
        }

        return l > r ? l : r;
    }


    public boolean isBinarySearchTree() {
        return checkbinarySearchTree(root);
    }

    private boolean checkbinarySearchTree(Node node) {
        if(node == null) return true;
        if(
            isSubTreeLesser(node.left, node.value)
            && isSubTreeGreater(node.right, node.value)
        ) {
            return checkbinarySearchTree(node.left) && checkbinarySearchTree(node.right);
        }
        
        return false;
    }

    private boolean isSubTreeLesser(Node node, int value) {
        if(node == null) return true;
        if(node.value < value) {
            return isSubTreeLesser(node.left, value) && isSubTreeLesser(node.right, value);
        }

        return false;
    }

    private boolean isSubTreeGreater(Node node, int value) {
        if(node == null) return true;

        if(node.value > value) {
            return isSubTreeGreater(node.left, value) && isSubTreeGreater(node.right, value);
        }

        return false;
    }
}
