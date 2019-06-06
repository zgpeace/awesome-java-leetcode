package number;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/happy-number/
public class HappyNumber {
  public boolean isHappy(int n) {
    // record pass number, validate whether is cycle
    Set<Integer> set = new HashSet<>();
    // current number
    Queue<Integer> queue = new LinkedList<>();
    set.add(n);
    queue.add(n);
    // sum
    int sum;
    int current;
    int remainder;
    while (!queue.isEmpty()) {
      current = queue.poll();
      sum = 0;
      while (current != 0) {
        remainder = current % 10;
        sum += remainder * remainder;
        current = current / 10;
      }
      if (sum == 1) {
        return true;
      }
      if (set.contains(sum)) {
        return false;
      }
      queue.add(sum);
      set.add(sum);
    }

    return false;
  }

  public boolean isHappyWithSet(int n) {
    // valid whether is loop
    Set<Integer> isLoopSet = new HashSet<>();
    int current = n;
    int sum;
    int remainder;
    while (isLoopSet.add(current)) {
      sum = 0;
      while (current != 0) {
        remainder = current % 10;
        sum += remainder * remainder;
        current = current / 10;
      }
      if (sum == 1) {
        return true;
      }
      current = sum;
    }

    return false;
  }
}
