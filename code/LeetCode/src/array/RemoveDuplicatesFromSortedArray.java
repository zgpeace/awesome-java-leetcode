package array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int current = nums[0];
    int count = 1;

    for (int i = 1; i < nums.length; i++) {
      if (current != nums[i]) {
        nums[count] = nums[i];
        current = nums[i];
        count++;
      }
    }

    return count;
  }
}
