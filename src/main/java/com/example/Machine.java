package com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Machine {
  public static void main(String[] args) {
    Integer[] integers = new Integer[] {100, 20, 35, 40, 15};
    int[] intArray = new int[] {100, 20, 35, 40, 15};
    int[] intArray2 = new int[] {100, 20, 35, 40, 15};

    for (int i = 0; i < integers.length; i++) {
      System.out.println(integers[i]);
    }

    Arrays.sort(integers);

    System.out.println("Sorted integers: " + Arrays.toString(integers));

    List<Integer> list = Arrays.asList(integers);

    // Arrays.sort(integers, (a, b) -> b - a);
    Arrays.sort(integers, Collections.reverseOrder());

    System.out.println("Sorted integers in descending order: " + Arrays.toString(integers));

    bubbleSort(intArray);

    for (int i = 0; i < intArray.length; i++) {
      System.out.println(intArray[i]);
    }

    insertionSort(intArray2);

    for (int i = 0; i < intArray2.length; i++) {
      System.out.println(intArray2[i]);
    }



    int[] numbers = {4, 5, 1, 3, 7, 4, 1};
  }

  public static void bubbleSort(int[] arr) {
    int n = arr.length;
    
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void insertionSort(int[] arr) {
    int n = arr.length;

    for (int i = 1; i < n; ++i) {
      int key = arr[i];
      int j;

      // while (j >= 0 && arr[j] > key) {
      //   arr[j + 1] = arr[j];
      //   j = j - 1;
      // }

      // arr[j + 1] = key;

      for (j = i - 1; j >= 0 && arr[j] > key; j--) {
        arr[j + 1] = arr[j];
      }

      arr[j + 1] = key;

    }
  }

  public static void selectionSort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;

      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }
}
