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

    mergeSort(numbers, 0, numbers.length - 1);
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

  public static void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;

      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      merge(arr, l, m, r);
    }
  }

  public static void merge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int[] L = new int[n1];
    int[] R = new int[n2];

    for (int i = 0; i < n1; i++) {
      L[i] = arr[l + i];
    }

    for (int j = 0; j < n2; j++) {
      R[j] = arr[m + 1 + j];
    }

    int i = 0, j = 0;
    int k = l;

    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }

      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);

      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }
}
