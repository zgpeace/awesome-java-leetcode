import java.util.Arrays;

public class ThreeSumClosest {
    /*
    3Sum Closest
    Description
    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    Example:

    Given array nums = [-1, 2, 1, -4], and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    Tags: Array, Two Pointers
     */

    /*
    思路
    题意是让你从数组中找出最接近 target 的三个数的和，该题和 3Sum 的思路基本一样，先对数组进行排序，
    然后遍历这个排序数组，用两个指针分别指向当前元素的下一个和数组尾部，判断三者的和与 target 的差值来移动两个指针，
    并更新其结果，当然，如果三者的和直接与 target 值相同，那么返回 target 结果即可。
     */

    public int threeSumClosest(int[] nums, int target) {
        int gapMin = Integer.MAX_VALUE;
        int closestTarget = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right && left < len) {
                int sum = nums[i] + nums[left] + nums[right];
                int currentGap = Math.abs(sum - target);
                if (currentGap == 0) {
                    return sum;
                }
                if (currentGap < gapMin) {
                    gapMin = currentGap;
                    closestTarget = sum;
                }

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return closestTarget;
    }

    public static void main(String[] args) {
        ThreeSumClosest object = new ThreeSumClosest();
        int[] input = {-1, 2, 1, -4};
        int target = 1;
        System.out.println("input: {-1, 2, 1, -4}, target: " +target+ ", ouput: " + object.threeSumClosest(input, target));
    }







































}
