package com.example;

import java.util.Arrays;

public class App 
{
    public static void bubbleSort(int[] arr) {
        int arrLength = arr.length;

        for (int i = 0; i < arrLength - 1; i++) {
            for (int j = 0; j < arrLength - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static void selectedSort(int[] arr) {
        int arrLength = arr.length;
        for (int i = 0; i < arrLength - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arrLength; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    private void insertSort(int[] arr) {
        int arrLength = arr.length;
        for (int i = 1; i < arrLength; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
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

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
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

    static void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }

    // public static void heapSort(int arr[]) {
    //     int n = arr.length;

    //     for (int i = n / 2 - 1; i >= 0; i--) {
    //         heapify(arr, n, i);
    //     }

    //     for (int i = n - 1; i > 0; i--) {
    //         int temp = arr[0];
    //         arr[0] = arr[i];
    //         arr[i] = temp;

    //         heapify(arr, i, 0);
    //     }
    // }

    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        // int[] arr = new int[5];
        // arr[0] = 5;
        // arr[1] = 4;
        // arr[2] = 23;
        // arr[3] = 12;
        // arr[4] = 1;
        // bubbleSort(arr);
        // System.out.println(Arrays.toString(arr));

        // int[] arr2 = new int[] {5, 4, 23, 12, 1};
        // selectedSort(arr2);
        // System.out.println(Arrays.toString(arr2));

        // int[] arr3 = new int[] {5, 4, 23, 12, 1};
        // App app = new App();
        // app.insertSort(arr3);
        // System.out.println(Arrays.toString(arr3));

        // int[] arr4 = new int[] {5, 4, 23, 12, 1};
        // quickSort(arr4, 0, arr4.length - 1);
        // System.out.println(Arrays.toString(arr4));

        // int a, b;
        // a = 10;
        // b = 20;
        // System.out.println("Before swap: a = " + a + " b = " + b);
        // swap(a, b);
        // System.out.println("After swap: a = " + a + " b = " + b);

        for (int i = 1; i <= 1000; i++) {
            int a = 0;
 
            for (int j = 1; j <= i; j++) {
 
                if (i % j == 0) {
                    a = a + j;
                }
            }
            if (i == a - i) {
                System.out.print(i + " ");
            }
 
        }

        // int a = 10;
        // int b = 8;

        // System.out.println(a % b);
    }
}
