package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://ac.nowcoder.com/acm/contest/3286/D
public class PickupCards {

  public static void main(String[] args) {
    PickupCards obj = new PickupCards();
    //int[] inputs = {7, 9, 8, 9};
    //int target = 8;
    int[] inputs = {3, 6, 2, 8, 7, 6, 5, 9};
    int target = 5;
    int result = obj.pickupCards(inputs, target);

    System.out.println("result > " + result);
  }

  public int pickupCards(int[] inputs, int target) {
    // check edges
    if (inputs == null || inputs.length == 0) {
      return 0;
    }
    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    Arrays.sort(inputs);
    List<Integer> list = new ArrayList<Integer>();
    //dfs
    dfs(inputs, resultList, list, 0, target);

    return resultList.size();
  }

  private void dfs(int[] inputs, List<List<Integer>> resultList, List<Integer> list, int start, int target) {
    // exit condition
    long sum = 0;
    for (int item: list) {
      sum += item;
    }
    if (list.size() != 0 && sum / list.size() == target && sum % list.size() == 0) {
      System.out.println(Arrays.toString(list.toArray()));
      resultList.add(new ArrayList<Integer>(list));
      return;
    }

    if (start >= inputs.length) {
      return;
    }

    list.add(inputs[start]);
    dfs(inputs, resultList, list, start + 1, target);
    list.remove(list.size() - 1);
    dfs(inputs, resultList, list, start + 1, target);
  }
}
