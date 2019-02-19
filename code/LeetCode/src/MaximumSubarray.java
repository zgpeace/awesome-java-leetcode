public class MaximumSubarray {
    /*
    Maximum Subarray
    Description
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:

    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

    Tags: Array, Divide and Conquer, Dynamic Programming
     */

    /*
    思路 0
    题意是求数组中子数组的最大和，这种最优问题一般第一时间想到的就是动态规划，
    我们可以这样想，当部分序列和大于零的话就一直加下一个元素即可，并和当前最大值进行比较，
    如果出现部分序列小于零的情况，那肯定就是从当前元素算起。
    其转移方程就是 dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);，
    由于我们不需要保留 dp 状态，故可以优化空间复杂度为 1，即 dp = nums[i] + (dp > 0 ? dp : 0);。
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int passSum = maxSum;

        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (passSum <= 0) {
                startIndex = i;
            }
            passSum = nums[i] + (passSum > 0 ? passSum : 0);
            if (passSum > maxSum) {
                maxSum = passSum;
                endIndex = i;
            }
        }

        System.out.print("maxSubArray: [");
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.print("] \n");

        return maxSum;
    }

    public static void main(String[] args) {
        int[] input = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("input: " + input);
//        System.out.println("maxSum: " + maxSubArray(input));

        System.out.println("maxSum: " + maxSubArrayWithDivideConquer(input));
    }

    /*
    思路 1
    题目也给了我们另一种思路，就是分治，所谓分治就是把问题分割成更小的，最后再合并即可，
    我们把 nums 一分为二先，那么就有两种情况，一种最大序列包括中间的值，一种就是不包括，也就是在左边或者右边；
    当最大序列在中间的时候那我们就把它两侧的最大和算出即可；当在两侧的话就继续分治即可。
     */
    public static int maxSubArrayWithDivideConquer(int[] nums) {
        return devideHelper(nums, 0, nums.length - 1);
    }

    private static int devideHelper(int[] nums, int left, int right) {
        if (left >= right) return nums[left];
        int mid = (left + right) >> 1;
        int leftDevideMax = devideHelper(nums, left, mid);
        int rightDevideMax = devideHelper(nums, mid + 1, right);
        int leftMax = nums[mid];
        int rightMax = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= left ; --i) {
            temp += nums[i];
            if (temp > leftMax) {
                leftMax = temp;
            }
        }

        temp = 0;
        for (int i = mid + 1; i <= right ; i++) {
            temp += nums[i];
            if (temp > rightMax) {
                rightMax = temp;
            }
        }

        return Math.max(Math.max(leftDevideMax, rightDevideMax), leftMax + rightMax);
    }






















}
