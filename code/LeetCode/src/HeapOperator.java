import java.util.Arrays;

/**
 * 最小堆， 例子🌰
 *      1
 *    2   3
 *  4   5   6
 */
public class HeapOperator {

    /**
     * 上浮：改变最后一个值，上浮使其成为最小堆
     * @param array 待调整的堆
     */
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex -1 ) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            //无需真正交换，单项赋值即可
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;

    }

    /**
     * 下沉：父节点与两个子节点中小的比较，父节点 > 小的子节点， 则替换
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int childIndex = parentIndex * 2 + 1;
        int temp = array[parentIndex];
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }

            if (temp <= array[childIndex]) {
                break;
            }

            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = childIndex * 2 + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 建堆
     * @param array 待调整的堆
     */
    public static void buildHeap(int[] array) {
        // 从最后一个非叶子节点开始，依次下沉调整
        int length = array.length;
        int lastIndex = length -1;
        int parentIndex = (lastIndex - 1) / 2;
        for (int i = parentIndex; i >= 0; i--) {
            downAdjust(array, i, length);
        }
    }

    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array) {
        //建堆
        buildHeap(array);
        System.out.println(Arrays.toString(array));

        int length = array.length;
        int lastIndex = length -1;

        for (int i = lastIndex; i > 0 ; i--) {
            // 把第一个跟最后一个交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            downAdjust(array, 0, i);
        }
    }

    public static void main(String[] args) {
//        int[] array = new int[]{1,3,2,6,5,7,8,9,10,0};
//        upAdjust(array);
//        System.out.println(Arrays.toString(array));
//
//        array = new int[] {7,1,3,10,5,2,8,9,6};
//        buildHeap(array);
//        System.out.println(Arrays.toString(array));

        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}


































