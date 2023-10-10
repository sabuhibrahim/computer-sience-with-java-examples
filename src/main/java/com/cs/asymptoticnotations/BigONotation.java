package com.cs.asymptoticnotations;

// worst scenario
public class BigONotation {
  private int[] array;
  private int size;
  private int index = 0;

  public BigONotation(int size) {
    this.size = size;
    this.array = new int[size];
    fillArray();
  }

  public void fillArray() {
    for (int i = 0; i < size; i++) {
      array[i] = (int) (Math.random() * 1000);
    }
    index = size - 1;
  }

  public int getValue(int i) {
    return array[i];
  }

  // add Item to array is O(1) time complexity
  // No mather how many items inside in array
  // it stays constant to adding new item
  // Constant runtime
  public void addItem(int item) {
    array[index++] = item;
  }

  // Linear search is O(n) time complexity
  // linear runtime
  public int linearSearch(int value) {
    for (int i = 0; i < size; i++) {
      if (value == array[i]) {
        return i;
      }
    }

    return -1;
  }

  // BubleSort is O(n^2) time complexity
  // Polynomial runtime
  public void bubleSort() {
    for (int i = size - 1; i > 1; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j + 1]) {
          swap(j, j + 1);
        }
      }
    }
  }

  // binary search is O(log(n)) time complexity
  // Logaritmic runtime
  public int binarySearch(int value) {
    int lowIndex = 0;
    int highIndex = size - 1;

    while (lowIndex <= highIndex) {
      int middleindex = (lowIndex + highIndex) / 2;
      if (array[middleindex] < value) {
        lowIndex = middleindex + 1;
      } else if (array[middleindex] > value) {
        highIndex = middleindex - 1;
      } else {
        return middleindex;
      }
    }

    return -1;
  }

  public void quickSort() {
    quickSort(0, size - 1);
  }

  // Quick sort is O(n log(n)) time complexity
  public void quickSort(int left, int right) {
    if (left - right > 0) {
      return;
    }

    int pivot = array[right];

    int pivotLocation = partionArr(left, right, pivot);
    quickSort(left, pivotLocation - 1);
    quickSort(pivotLocation + 1, right);
  }

  private int partionArr(int left, int right, int pivot) {
    int leftpointer = left - 1;
    int rightpointer = right;

    while (true) {
      while (array[++leftpointer] < pivot)
        ;
      while (rightpointer > 0 && array[--rightpointer] > pivot)
        ;
      if (leftpointer >= rightpointer) {
        break;
      } else {
        swap(leftpointer, rightpointer);
      }
    }
    swap(leftpointer, right);
    return leftpointer;
  }

  private void swap(int indexOne, int indexTwo) {
    int a = array[indexOne];
    array[indexOne] = array[indexTwo];
    array[indexTwo] = a;
  }

  // O(2 ^ n) time complexity
  // Exponential runtime
  public long exponentialExample(long n) {
    if (n == 0) {
      return 1;
    }

    return 2 * exponentialExample(n - 1);
  }

  // O(n!) time complexity
  // Factorial runtime
  public long factorial(long n) {
    if (n == 0)
      return 1;
    return n * factorial(n - 1);
  }

}
