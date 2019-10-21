package binarysearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {

  public static void main(String[] args) {
    SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
    int[] nums = {1, 3};
    obj.search(nums, 3);
  }

  public int search(int[] nums, int target) {
    // check edge
    if (nums == null || nums.length == 0) {
      return -1;
    }
    // find the divide index
    int divideIndex = findDividIndex(nums);
    if (target == nums[divideIndex]) {
      return divideIndex;
    }
    int lastIndex = nums.length - 1;
    int beginIndex = target > nums[lastIndex] ? 0 : divideIndex;
    int endIndex = target > nums[lastIndex] ? divideIndex : lastIndex;
    while (beginIndex <= endIndex) {
      int midIndex = beginIndex + ((endIndex - beginIndex) >> 1);
      if (target == nums[midIndex]) {
        return midIndex;
      } else if (target > nums[midIndex]) {
        beginIndex = midIndex + 1;
      } else {
        endIndex = midIndex - 1;
      }
    }

    return -1;
  }

  private int findDividIndex(int[] nums) {
    int from = 0;
    int to = nums.length - 1;
    while (from < to) {
      int mid = from + ((to - from) >> 1);
      if (nums[mid] > nums[to]) {
        from = mid + 1;
      } else {
        to = mid;
      }
    }

    return from;
  }
  
}
