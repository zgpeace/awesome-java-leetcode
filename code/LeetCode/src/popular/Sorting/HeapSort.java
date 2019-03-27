package popular.Sorting;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] data) {
        // build top big heap
        for (int i = data.length/2 -1; i >= 0; i--) {
            // build heap
            buildHeap(data, i, data.length);
        }

        // change seat between the first and the last, length--
        for (int k = data.length - 1; k >=0; k--) {
            // change seat between first and last one
            swap(data, 0, k);
            // build heap
            buildHeap(data, 0, k);
        }
    }

    public static void buildHeap(int[] data, int nodeIndex, int length) {
        int temp = data[nodeIndex];
        for (int k = nodeIndex * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && data[k] < data[k + 1]) {
                k = k + 1;
            }
            if (data[k] > temp) {
                data[nodeIndex] = data[k];
                nodeIndex = k;
            } else {
                break;
            }
        }

        data[nodeIndex] = temp;
    }


    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = new int[]{4, 6, 5, 3, 7, 1, 2};
        System.out.println(Arrays.toString(data));
        heapSort(data);
        System.out.println(Arrays.toString(data));
    }
}
