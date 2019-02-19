import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /*
    3Sum
    Description
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
    [
      [-1, 0, 1],
      [-1, -1, 2]
    ]
    Tags: Array, Two Pointers
     */

    /*
    思路
    题意是让你从数组中找出所有三个和为 0 的元素构成的非重复序列，这样的话我们可以把数组先做下排序，
    然后遍历这个排序数组，用两个指针分别指向当前元素的下一个和数组尾部，判断三者的和与 0 的大小来移动两个指针，
    其中细节操作就是优化和去重。
     */

    public static void main(String[] args) {
        ThreeSum object = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resultList = object.threeSum(nums);
        System.out.println("resultList: " + resultList);
    }



    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int sumTarget = 0;
        int length = nums.length;
        // 1. delete impossible edge: nums < 3
        if (length < 3) {
            return resultList;
        }

        // 2. order nums
        Arrays.sort(nums);


        // 3. delete impossible edge: biggest * 3 < 0
        if (nums[length - 1] + nums[length - 2] + nums[length -3] < sumTarget) {
            return resultList;
        }


        // 4. delete impossible edge: smallist * 3 > 0
        if (nums[0] + nums[1] + nums[2] > sumTarget) {
            return resultList;
        }


        // for loop
        for (int i = 0; i < length - 2; ) {
            // smallest > 0, break
            if (nums[i] > 0) {
                break;
            }

            // 5. otherwise, smallest + 2 * biggis < 0, smallest ++
            while (nums[i] + nums[length -1] * 2 < sumTarget && i < length - 2) {
                i++;
            }
            // 6. otherwise, smallest * 2 + biggis > 0, smallest --
            while (nums[i] * 2 + nums[length - 1] > sumTarget && i < length - 2) {
                length--;
            }

            int left = i + 1;
            int right = length - 1;
            //i 与两头缩放
            while (left < right) {
                // 7. find the meet target,
                if (nums[i] + nums[left] + nums[right] == sumTarget) {
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // then skip while(nums[left] == nums[++left], and left < right)    ,
                    while (nums[left] == nums[++left] && left < right) { }
                    // then skip while(nums[right] == nums[--right], and left < right)
                    while (nums[right] == nums[--right] && left < right) { }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    // 8. else if, nums[left] + nums[left + 1] + nums[right] < 0,
                    // while(nums[left] == nums[++left], and left < right)
                    while (nums[left] == nums[++left] && left < right) { }
                } else {
                    // 9. else if, nums[i] + nums[left] + nums[right] > 0,
                    // while(nums[right] == nums[--right], and left < right)
                    while (nums[right] == nums[--right] && left < right) { }
                }
            }

            while (nums[i] == nums[++i] && i < length - 2) { }


        }


        return resultList;
    }

































}
