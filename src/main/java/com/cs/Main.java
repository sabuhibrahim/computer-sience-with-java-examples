package com.cs;

import com.cs.asymptoticnotations.BigONotation;
import com.cs.commonalgorithms.Sorting;
import com.cs.datastructures.DataStructureExamples;

public class Main {
    public static void main(String[] args) throws Exception {

        // LinkedList
        // DataStructureExamples.linkedList();

        // Stack
        // DataStructureExamples.stack();

        // Queue
        // DataStructureExamples.queue();

        // Hash Table
        // DataStructureExamples.hashTable();

        // Binary Tree
        // DataStructureExamples.binaryTree();

        // Graph
        // DataStructureExamples.graph();

        // Heap
        // DataStructureExamples.heap();

        // BigONotation notation = new BigONotation(100000);

        // long startTime = System.currentTimeMillis();

        // notation.bubleSort();
        // notation.quickSort();

        // System.out.println("Buble sort time: " + (System.currentTimeMillis() -
        // startTime));

        // int val = notation.getValue(90000);

        // startTime = System.currentTimeMillis();

        // System.out.println("Linear Search res: " + "val: " + val + " " +
        // notation.linearSearch(val) + " Time: "
        // + (System.currentTimeMillis() - startTime));

        // startTime = System.currentTimeMillis();

        // System.out.println("Binary Search res: " + "val: " + val + " " +
        // notation.binarySearch(val) + " Time: "
        // + (System.currentTimeMillis() - startTime));

        int size = 20;
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
            System.out.print(array[i] + " ");
        }

        System.out.println("\n");

        // Sorting.bubleSort(array, false);

        // Sorting.selectionSort(array, true);

        // Sorting.insertionSort(array, true);

        // Sorting.mergeSort(array, true);
        // Sorting.quickSort(array, true);
        Sorting.heapSort(array, true);

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

}