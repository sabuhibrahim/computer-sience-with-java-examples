package com.cs.commonalgorithms;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * All Sorting algorthm examples
 * Which algorithm is best it depends on the array state
 * Random, Nearly sorted, Reversed, Few Unique
 * You can see good animation examples at the:
 * https://www.toptal.com/developers/sorting-algorithms
 */
public class Sorting {

  /*
   * Bubble Sort
   * Best Case Time Complexity: O(n)
   * Worst Case Time Complexity: O(n^2)
   * Average Case Time Complexity: O(n^2)
   * Space complexity: O(1)
   */
  public static void bubleSort(int[] arr) {
    bubleSort(arr, false);
  }

  public static void bubleSort(int[] arr, boolean reverse) {
    int len = arr.length;
    for (int i = len - 1; i > 1; i--) {
      for (int j = 0; j < i; j++) {

        if (!reverse && arr[j] > arr[j + 1]) {
          swap(arr, j, j + 1);
        } else if (reverse && arr[j] < arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }
  }

  /*
   * Selection sort
   * Best case time complexity: O(n^2)
   * Average case time complexty: O(n^2)
   * Worst case time complexity: O(n^2)
   * Space complexity: O(1)
   */
  public static void selectionSort(int[] arr) {
    selectionSort(arr, false);
  }

  public static void selectionSort(int[] arr, boolean reverse) {
    int len = arr.length;
    for (int i = 0; i < len - 1; i++) {
      int c = i;
      for (int j = i + 1; j < len; j++) {
        if (!reverse && arr[c] > arr[j]) {
          c = j;
        } else if (reverse && arr[c] < arr[j]) {
          c = j;
        }
      }
      swap(arr, i, c);
    }
  }

  /*
   * Insertion Sort
   * Worst case time complexity O(n^2)
   * Average case time complexty: O(n^2)
   * Best case time complexty: O(n)
   * Space complexity: O(1)
   * is preferred to working with a linked list
   * Insertion sort takes the maximum time to sort
   * if elements are sorted in reverse order.
   * And it takes minimum time (Order of n) when elements are already sorted.
   */
  public static void insertionSort(int[] arr) {
    insertionSort(arr, false);
  }

  public static void insertionSort(int[] arr, boolean reverse) {
    int len = arr.length;
    for (int i = 1; i < len; i++) {
      for (int j = i; j > 0; j--) {
        if (!reverse && arr[j] < arr[j - 1]) {
          swap(arr, j, j - 1);
        } else if (reverse && arr[j] > arr[j - 1]) {
          swap(arr, j, j - 1);
        }
      }
    }
  }

  /*
   * Merge Sort
   * Worst case time complexity O(n * log n)
   * Average case time complexty: O(n * log n)
   * Best case time complexty: O(n * log n)
   * Space complexity: O(n)
   */
  public static void mergeSort(int[] arr) {
    mergeSort(arr, false);
  }

  public static void mergeSort(int[] arr, boolean reverse) {
    mergeSort(arr, reverse, 0, arr.length - 1);
  }

  public static void mergeSort(int[] arr, boolean reverse, int l, int r) {
    if (l < r) {

      // Find the middle point
      int m = l + (r - l) / 2;

      // Sort first and second halves
      mergeSort(arr, reverse, l, m);
      mergeSort(arr, reverse, m + 1, r);

      // Merge the sorted halves
      merge(arr, l, m, r, reverse);
    }
  }

  private static void merge(int arr[], int l, int m, int r, boolean reverse) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    // Create temp arrays
    int L[] = new int[n1];
    int R[] = new int[n2];

    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    // Merge the temp arrays

    // Initial indices of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
      if (!reverse && L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else if (reverse && L[i] >= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    // Copy remaining elements of L[] if any
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    // Copy remaining elements of R[] if any
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  /*
   * Quick Sort
   * Worst case time complexity O(n^2)
   * Average case time complexty: O(n * log n)
   * Best case time complexty: O(n * log n)
   * Space complexity: O(1)
   */
  public static void quickSort(int[] arr) {
    quickSort(arr, false);
  }

  public static void quickSort(int[] arr, boolean reverse) {
    quickSort(arr, reverse, 0, arr.length - 1);
  }

  public static void quickSort(int[] arr, boolean reverse, int low, int high) {
    if (low < high) {

      // pi is partitioning index, arr[p]
      // is now at right place
      int pi = partition(arr, reverse, low, high);

      // Separately sort elements before
      // partition and after partition
      quickSort(arr, reverse, low, pi - 1);
      quickSort(arr, reverse, pi + 1, high);
    }
  }

  private static int partition(int[] arr, boolean reverse, int low, int high) {
    // Choosing the pivot
    int pivot = arr[high];

    // Index of smaller element and indicates
    // the right position of pivot found so far
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++) {

      // If current element is smaller than the pivot
      if ((!reverse && arr[j] < pivot) || (reverse && arr[j] > pivot)) {

        // Increment index of smaller element
        i++;
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return (i + 1);
  }

  /*
   * Quick Sort
   * Worst case time complexity O(n * log n)
   * Average case time complexty: O(n * log n)
   * Best case time complexty: O(n * log n)
   * Space complexity: O(1)
   * https://www.geeksforgeeks.org/heap-sort/
   */
  public static void heapSort(int[] arr) {
    heapSort(arr, false);
  }

  // This is heap sort example with PriorityQueue
  public static void heapSort(int[] arr, boolean reverse) {

    Queue<Integer> heap;
    if (!reverse) {
      heap = new PriorityQueue<Integer>();
    } else {
      heap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    for (int i = 0; i < arr.length; ++i) {
      heap.add(arr[i]);
    }

    for (int j = 0; j < arr.length; ++j) {
      arr[j] = heap.poll();
    }
  }

  private static void swap(int[] arr, int lowIndex, int highIndex) {
    int a = arr[highIndex];
    arr[highIndex] = arr[lowIndex];
    arr[lowIndex] = a;
  }
}
