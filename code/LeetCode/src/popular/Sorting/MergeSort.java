package popular.Sorting;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] data) {
        int[] temp = new int[data.length];
        subMergeSort(data, 0, data.length - 1, temp);
    }


    public void subMergeSort(int[] data, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            subMergeSort(data, left, mid, temp);
            subMergeSort(data, mid + 1, right, temp);
            merge(data, left, mid, right, temp);
        }
    }

    public void merge(int[] data, int left, int mid, int right, int[] temp) {
        int i = left;
        int k = mid + 1;
        int t = 0;
        while (i <= mid && k <= right) {
            if (data[i] < data[k]) {
                temp[t++] = data[i++];
            } else {
                temp[t++] = data[k++];
            }
        }

        while (i <= mid) {
            temp[t++] = data[i++];
        }

        while (k <= right) {
            temp[t++] = data[k++];
        }

        t = 0;
        while (left <= right) {
            data[left++] = temp[t++];
        }

    }

    public static void main(String[] args) {
        int[] data = new int[]{4, 6, 5, 3, 7, 1, 2};
        System.out.println(Arrays.toString(data));
        MergeSort obj = new MergeSort();
        obj.mergeSort(data);
        System.out.println(Arrays.toString(data));
    }


}
