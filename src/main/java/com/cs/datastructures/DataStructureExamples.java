package com.cs.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class DataStructureExamples {
    /*
     * Arrays example
     * Linear data structure
     * It stores items at contiguous memory locations
     */
    public static void array() {
        int[] arr1 = {1, 2, 4, 3};

        System.out.println("------------- Array Start -------------");

        System.out.println(arr1);

        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(1);
        arr2.add(5);

        System.out.println(arr2);

        System.out.println("------------- Array End -------------");
    }
    
    /*
     * Linked list structure example
     * Linear data structure
     * It stores data as value and referance next node
     * Elements are not stored at contiguous memory locations like array.
     * inside node
     */
    public static void linkedList() {
        List<Integer> linkedList = new LinkedList<Integer>();

        linkedList.add(5);
        linkedList.add(12);
        linkedList.add(17);

        System.out.println("------------- Linked List Start -------------");
        System.out.println(linkedList);

        System.out.println("------------- Linked List End -------------");
    }

    /*
     * Stack data structure example
     * Linear data structure
     * It stores data like linked list
     * It follows Last in First out principle (LIFO)
     */
    public static void stack() {
        Stack<Integer> stack = new Stack<Integer>();

        stack.add(5);
        stack.add(7);
        stack.add(9);

        System.out.println("------------- Stack Start -------------");

        System.out.println(stack);
        Integer last = stack.pop();
        System.out.println(last);
        System.out.println(stack);

        System.out.println("------------- Stack End -------------");
    }

    /*
     * Queue Data Structure example
     * Linear data structure
     * It stores data as Linked list
     * Value and referance to next
     * It follows First in First out principle (FIFO)
     */
    public static void queue() {

        // First in First Out FIFO
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(5);
        queue.add(12);
        queue.add(17);

        System.out.println("------------- Queue Start -------------");
        
        System.out.println(queue);

        int first = queue.remove();

        System.out.println(first);

        System.out.println(queue);

        System.out.println("------------- Queue End -------------");

    }

    /*
     * Hash Table Data Structure example
     * Non-Linear data structure
     * It stores data as key value and hash id generated from key
     */
    public static void hashTable() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

        hashMap.put("one", 1);
        hashMap.put("second", 2);
        
        System.out.println("------------- Hash Table Start -------------");
        
        System.out.println(hashMap.size());
        System.out.println(hashMap);

        System.out.println("------------- Hash Table end -------------");
    }

    /*
     * Tree Data Structure
     * Non-Linear data structure
     * It stores data as like tree 
     * Ex: Grand grand Parent -> grand parents -> parents -> childs
     * In this example it uses custom BinaryTree class
     * And It follows Binary Search Tree prinsiples
     */
    public static void binaryTree() throws Exception {

        BinaryTree tree = new BinaryTree();
        tree.add(10);
        tree.add(9);
        tree.add(14);
        tree.add(21);

        tree.add(4);
        tree.add(11);
        tree.add(19);

        tree.add(1);
        tree.add(7);
        tree.add(24);
        tree.add(8);
        tree.add(6);
        tree.add(5);
        tree.add(3);
        tree.add(2);
        tree.add(12);
        tree.add(13);
        tree.add(15);
        tree.add(16);

        System.out.println("------------- Binary Tree Start -------------");

        System.out.println("Contain 1: " + tree.contain(1));

        System.out.println("Contain 4: " + tree.contain(4));

        System.out.println("Max value is: " + tree.max());

        System.out.println("Min value is: " + tree.min());

        System.out.println("Height value is: " + tree.height());

        tree.printTree();

        tree.print();

        System.out.println("\nIs Binary Search Tree: " + tree.isBinarySearchTree());

        tree.delete(7);
        tree.delete(21);

        System.out.println("\nIs Binary Search Tree: " + tree.isBinarySearchTree());

        tree.printTree();

        System.out.println("------------- Binary Tree End -------------");
    }


    /*
     * Graph data structure
     * Non-Linear data structure
     */
    public static void graph() {
        Graph fcGraph = new Graph();

        fcGraph.addVertex("RealMadrid");
        fcGraph.addVertex("Barcelona");
        fcGraph.addVertex("Milano");
        fcGraph.addVertex("Inter");
        fcGraph.addVertex("ManchesterUnited");
        fcGraph.addEdge("RealMadrid", "Barcelona");
        fcGraph.addEdge("RealMadrid", "Inter");
        fcGraph.addEdge("Barcelona", "Milano");
        fcGraph.addEdge("Milano", "ManchesterUnited");
        fcGraph.addEdge("ManchesterUnited", "Inter");
        fcGraph.addEdge("ManchesterUnited", "RealMadrid");

        System.out.println("------------- Graph Start -------------");

        System.out.println(fcGraph);
        
        System.out.println(fcGraph.depthFirstTraversal("RealMadrid"));
        System.out.println(fcGraph.breadthFirstTraversal("Barcelona"));

        System.out.println("------------- Graph End -------------");
    }


    public static void heap() {
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        minHeap.add(56);
        minHeap.add(32);
        minHeap.add(27);
        minHeap.add(48);
        minHeap.add(72);
        minHeap.add(68);

        System.out.println("------------- Min Heap Start -----------\n");

        Iterator<Integer> it = minHeap.iterator();

        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        System.out.println("\nMin value is: " + minHeap.peek());

        System.out.println("------------- Min Heap End -----------");

        Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        maxHeap.add(56);
        maxHeap.add(32);
        maxHeap.add(27);
        maxHeap.add(48);
        maxHeap.add(72);
        maxHeap.add(68);

        System.out.println("------------- Max Heap Start -----------\n");

        Iterator<Integer> itMax = maxHeap.iterator();

        while(itMax.hasNext()) {
            System.out.print(itMax.next() + " ");
        }

        System.out.println("\nMax value is: " + maxHeap.peek());

        System.out.println("------------- Max Heap End -----------");

    }
}
