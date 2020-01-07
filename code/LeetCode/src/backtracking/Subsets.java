package backtracking;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets {

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3};
    Subsets obj = new Subsets();
    //List<List<Integer>> resultList = obj.subsets(nums);
    //List<List<Integer>> resultList = obj.subsetsWithRecursion(nums);
    //List<List<Integer>> resultList = obj.subsetsWithBacktrack(nums);
    List<List<Integer>> resultList = obj.subsetsWithBinarySorted(nums);
    System.out.println(Arrays.toString(resultList.toArray()));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    // dfs
    dfs(nums, resultList, new ArrayList<Integer>(), 0);

    return resultList;
  }

  private void dfs(int[] nums, List<List<Integer>> resultList, List<Integer> list, int index) {
    // exit
    if (nums == null || index == nums.length) {
      resultList.add(new ArrayList<Integer>(list));
      return;
    }

    // add item
    list.add(nums[index]);
    dfs(nums, resultList, list, index + 1);

    // not add item
    list.remove(list.size() - 1);
    dfs(nums, resultList, list, index + 1);
  }


  public List<List<Integer>> subsetsWithRecursion(int[] nums) {
    List<List<Integer>> outputList = new ArrayList<List<Integer>>();
    outputList.add(new ArrayList<Integer>());
    for (int num: nums) {
      List<List<Integer>> newList = new ArrayList<List<Integer>>();
      for (List<Integer> list: outputList) {
        newList.add(new ArrayList<Integer>(list) {{ add(num); }});
      }

      for (List<Integer> list: newList) {
        outputList.add(list);
      }
    }

    return outputList;
  }

  public List<List<Integer>> subsetsWithBacktrack(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    for (int len = 0; len <= nums.length; len++) {
      // backtrack
      backtrack(nums, resultList, new ArrayList<Integer>(), 0, len);
    }

    return resultList;
  }

  private void backtrack(int[] nums, List<List<Integer>> resultList, List<Integer> list, int first, int len) {
    // exit
    if (list.size() == len) {
      resultList.add(new ArrayList<Integer>(list));
      return;
    }

    if (first == nums.length) {
      return;
    }
    list.add(nums[first]);
    backtrack(nums, resultList, list, first + 1, len);
    list.remove(list.size() - 1);
    backtrack(nums, resultList, list, first + 1, len);
  }

  public List<List<Integer>> subsetsWithBinarySorted(int[] nums) {
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    int n = nums.length;

    for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n + 1); i++) {
      // generate bitmask, from 0..00 to 1..11
      String bitmask = Integer.toBinaryString(i).substring(1);

      // append subset corresponding to that bitmask
      List<Integer> list = new ArrayList<Integer>();
      for (int k = 0; k < n; k++) {
        if (bitmask.charAt(k) == '1') {
          list.add(nums[k]);
        }
      }

      resultList.add(list);
    }

    return resultList;
  }
}
