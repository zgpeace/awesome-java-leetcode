package backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutation-sequence/
public class PermutationSequence {

  public static void main(String[] args) {
    PermutationSequence obj = new PermutationSequence();
    String result = obj.getPermutation(4, 9);
    System.out.println("result > " + result);
  }

  public String getPermutation(int n, int k) {
    // factorial
    int[] factorial = new int[n + 1];
    factorial[0] = 1;
    int sum = 1;

    // create an array of factorial lookup
    for (int i = 1; i <= n; i++) {
      sum *= i;
      // factorial[] = {1, 1, 2, 6, 24, ..., n!}
      factorial[i] = sum;
    }

    // create a list of numbers to get indices
    List<Integer> items = new ArrayList<Integer>();
    for (int i = 1; i <= n; i++) {
      // numbers = {1, 2, 3, 4}
      items.add(i);
    }

    // i from 0, so k - 1
    k--;

    StringBuilder sb = new StringBuilder();
    // calculate
    for (int i = 1; i <= n; i++) {
      int index = k / factorial[n - i];
      int item = items.get(index);
      sb.append(String.valueOf(item));
      items.remove(index);
      k -= index * factorial[n - i];
    }

    return sb.toString();
  }
}
