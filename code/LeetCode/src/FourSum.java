import java.util.*;

public class FourSum {
    /*
    4Sum
    Description
    Given an array numsof n integers and an integer target, there are Elements has , b , c , and d in numsSuch That a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

    Note:

    The solution set must not contain duplicate quadruplets.

    example:

    Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

    A solution set is:
    [
      [-1,  0, 0, 1],
      [-2, -1, 1, 2],
      [-2,  0, 0, 2]
    ]
    Tags: Array, Hash Table, Two Pointers
     */

    /*
    思路 0
    意是让你题从数组中找出所有四个数的和为target的元素构成的非重复序列,该题和3sum的思路基本一样,
    先对数组进行排序,然后遍历这个排序数组,因为这次是四个元素的和,所以外层需要两重循环,
    然后还是用两个指针分别指向当前元素的下一个和数组尾部,四者的和判断与target的大小来移动两个指针,
    其中细节操作还是优化和去重.
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int max = nums[len - 1];
        if (max * 4 < target) {
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        int fistMaxIndex = len - 3;
        //最小
        for (int i = 0; i < fistMaxIndex; ) {
            //最小累加都大于target， 则退出
            if (nums[i] * 4 > target) {
                break;
            }
            //最小太小，则跳过
            if (nums[i] + max * 3 < target) {
                while (nums[i] == nums[++i] && i < fistMaxIndex) { }
                continue;
            }

            int secondMaxIndex = len - 2;
            for (int j = i + 1; j < secondMaxIndex; ) {
                int subTwo = nums[i] + nums[j];
                //最小累加都大于target， 则退出
                if (subTwo + nums[j] * 2 > target) {
                    break;
                }
                ////最小太小，则跳过
                if (subTwo + max * 2 < target) {
                    while (nums[j] == nums[++j] && j < secondMaxIndex) { }
                    continue;
                }

                int left = j + 1; int right = len - 1;
                while (left < right) {
                    if (subTwo + nums[left] + nums[right] == target) {
                        resultList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (nums[left] == nums[++left] && left < right) { }
                        while (nums[right] == nums[--right] && left < right) { }
                    } else if (subTwo + nums[left] + nums[right] < target) {
                        while (nums[left] == nums[++left] && left < right) { }
                    } else {
                        while (nums[right] == nums[--right] && left < right) { }
                    }
                }

                while (nums[j] == nums[++j] && j < secondMaxIndex) { }
            }

            while (nums[i] == nums[++i] && i < fistMaxIndex) { }
        }


        return resultList;
    }

    /*
    思路 1
    从Two Sum , 3sum到现在的4Sum,其实都是把高阶降为低阶,那么我们就可以写出kSum的函数来对其进行降阶处理,
    降到2Sum后那么我们就可以对其进行最后的判断了,代码如下所示,其也做了相应的优化和去重.
     */
    public List<List<Integer>> fourSumByDegreeDimension(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int max = nums[len - 1];
        if (max * 4 < target) {
            return Collections.emptyList();
        }
        List<List<Integer>> resultList = helperSum(nums, 0, 4, target);

        return resultList;
    }

    private List<List<Integer>> helperSum(int[] nums, int start, int capacity, int target) {
        List<List<Integer>> qualifiedList = new ArrayList<>();
        int len = nums.length;
        int max = nums[len - 1];

        if (capacity == 2) {
            int left = start;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] * 2 > target) {
                    break;
                }
                if (nums[left] + nums[right] == target) {
//                    qualifiedList.add(Arrays.asList(nums[left], nums[right]));
                    List<Integer> twoSum =  new LinkedList<>();
                    twoSum.add(nums[left]);
                    twoSum.add(nums[right]);
                    qualifiedList.add(twoSum);
                    while (nums[left] == nums[++left] && left < right) { }
                    while (nums[right] == nums[--right] && left < right) { }
                } else if (nums[left] + nums[right] < target) {
                    while (nums[left] == nums[++left] && left < right) { }
                } else {
                    while (nums[right] == nums[--right] && left < right) { }
                }
            }

        } else {
            int end = len - (capacity - 1);

            for (int i = start; i < end; ) {
                //太大的时候退出
                if (nums[i] * capacity > target) {
                    break;
                }
                //太小的时候，+1
                if (nums[i] + max * (capacity - 1) < target) {
                    while (nums[i] == nums[++i] && i < end) { }
                    continue;
                }
                List<List<Integer>> tempList = helperSum(nums, i+1, capacity - 1, target - nums[i]);
                for (List<Integer> subList: tempList) {
                    subList.add(0, nums[i]);
                }
                qualifiedList.addAll(tempList);
                while (nums[i] == nums[++i] && i < end) { }
            }

        }

        return qualifiedList;
    }

    public static void main(String[] args) {
        int[] input = {1, 0, -1, 0, -2, 2};
        int target = 0;
        FourSum obj = new FourSum();
//        List<List<Integer>> resultList = obj.fourSum(input, target);
        List<List<Integer>> resultList = obj.fourSumByDegreeDimension(input, target);

        System.out.print("output: " + resultList);
    }








































}
