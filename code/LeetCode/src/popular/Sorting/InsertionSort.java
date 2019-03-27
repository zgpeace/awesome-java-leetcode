package popular.Sorting;

import java.util.Arrays;

public class InsertionSort {

    public void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int currentNumber = data[i];
            int j = i - 1;
            while (j >= 0 && data[j] > currentNumber) {
                data[j + 1] = data[j];
                j--;
            }
            data[j+1] = currentNumber;
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{4, 6, 5, 3, 7, 1, 2};
        System.out.println(Arrays.toString(data));
        InsertionSort obj = new InsertionSort();
        obj.insertSort(data);
        System.out.println(Arrays.toString(data));
    }
}
