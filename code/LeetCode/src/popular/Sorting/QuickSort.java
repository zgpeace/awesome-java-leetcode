package popular.Sorting;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] data) {
        // divide to left, right index
        subQuickSort(data, 0, data.length - 1);
    }

    public static void subQuickSort(int[] data, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        // pivot data: mid of the three number, and swap to right -1
        buildPivotCloseToRight(data, leftIndex, rightIndex);

        int i = leftIndex;
        int k = rightIndex - 1;
        int pivot = data[k];
        // two point from two side, ++left, --right
        while (true) {

            // while ++left > pivot
            while ((i+1) < rightIndex && data[++i] < pivot) {

            }

            // while --right < pivot
            while ((k - 1) > leftIndex && data[--k] > pivot) {

            }

            // left < right, then swap
            if (i < k) {
                swap(data, i, k);
            } else {
                break;
            }
        }

        // if left < pivotIndex ,swap
        if (i < rightIndex - 1) {
            swap(data, i, rightIndex - 1);
        }

        // divide two sub quick sort
        subQuickSort(data, leftIndex, i);
        subQuickSort(data, i + 1, rightIndex);

    }

    public static void buildPivotCloseToRight(int[] data, int leftIndex, int rightIndex) {
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        // swap small in left, between left, mid
        if (data[leftIndex] > data[midIndex]) {
            swap(data, leftIndex, midIndex);
        }

        // swap small in left, between left, right
        if (data[leftIndex] > data[rightIndex]) {
            swap(data, leftIndex, rightIndex);
        }

        // swap big in right, between mid, right
        if (data[midIndex] > data[rightIndex]) {
            swap(data, midIndex, rightIndex);
        }

        // swap pivot int right -1
        swap(data, midIndex, rightIndex - 1);
    }

    public static void swap(int[] data, int i, int k) {
        int temp = data[i];
        data[i] = data[k];
        data[k] = temp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{4, 6, 5, 3, 7, 1, 2};
        System.out.println(Arrays.toString(data));
        quickSort(data);
        System.out.println(Arrays.toString(data));
    }
}
