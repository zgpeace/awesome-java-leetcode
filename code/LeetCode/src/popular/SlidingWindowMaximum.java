package popular;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] windowMaxArray = new int[len - k + 1];
        int[] leftMaxArray = new int[len];
        int[] rightMaxArray = new int[len];

        int rightIndex;
        for (int i = 0; i < len; i++) {
            leftMaxArray[i] = i % k == 0 ? nums[i] : Math.max(leftMaxArray[i - 1], nums[i]);
            rightIndex = len - i - 1;
            rightMaxArray[rightIndex] = (i == 0 || (rightIndex + 1) % k == 0) ? nums[rightIndex] : Math.max(rightMaxArray[rightIndex + 1], nums[rightIndex]);
        }

        for (int j = 0; j <= len - k; j++) {
            windowMaxArray[j] = Math.max(leftMaxArray[j + k - 1], rightMaxArray[j]);
        }

        return windowMaxArray;
    }

    public int[] maxSlidingWindowWithDeque(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] windowMax = new int[len - k + 1];
        int windowIndex = 0;
        // store index
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            // remove numbers out of range k
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // deque contains index... r contains content
            deque.offer(i);

            if (i + 1 >= k) {
                windowMax[windowIndex++] = nums[deque.peek()];
            }
        }

        return windowMax;
    }

    public static void main(String[] args) {
        //int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        //int[] windowMax = obj.maxSlidingWindow(nums, k);
        int[] windowMax = obj.maxSlidingWindowWithDeque(nums, k);
        System.out.println("Output: " + Arrays.toString(windowMax));
    }



}
