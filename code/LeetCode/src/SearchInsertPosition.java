public class SearchInsertPosition {
    /*
    Search Insert Position
    Description
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.

    Example 1:

    Input: [1,3,5,6], 5
    Output: 2
    Example 2:

    Input: [1,3,5,6], 2
    Output: 1
    Example 3:

    Input: [1,3,5,6], 7
    Output: 4
    Example 1:

    Input: [1,3,5,6], 0
    Output: 0
    Tags: Array, Binary Search
     */

    /*
    思路
    题意是让你从一个没有重复元素的已排序数组中找到插入位置的索引。
    因为数组已排序，所以我们可以想到二分查找法，因为查找到的条件是找到第一个等于或者大于 target 的元素的位置，所以二分法略作变动即可。
     */

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) >> 1;
        while (left <= right) {
            if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            middle = (left + right) >> 1;
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5,6};
        int target1 = 5;
        System.out.println("nums: " + nums1 + " target: " + target1 + " result: " + searchInsert(nums1, target1));

        int[] nums2 = {1,3,5,6};
        int target2 = 2;
        System.out.println("nums: " + nums2 + " target: " + target2 + " result: " + searchInsert(nums2, target2));

        int[] nums3 = {1,3,5,6};
        int target3 = 7;
        System.out.println("nums: " + nums3 + " target: " + target3 + " result: " + searchInsert(nums3, target3));

        int[] nums4 = {1,3,5,6};
        int target4 = 0;
        System.out.println("nums: " + nums4 + " target: " + target4 + " result: " + searchInsert(nums4, target4));
    }










}
