package array;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/count-and-say/
public class CountAndSay {
  public String countAndSay(int n) {
    if (n == 0) {
      return "1";
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    int size;
    Integer pre = null;
    int count = 1;
    Integer current;
    for (int i = 2; i <= n; i++) {
      size = queue.size();
      for (int k = 0; k < size; k++) {
        current = queue.poll();
        if (pre == current) {
          count++;
        } else {
          if (pre != null) {
            queue.add(count);
            queue.add(pre);
          }

          // reset date
          pre = current;
          count = 1;
        }
      }
      // add last
      queue.add(count);
      queue.add(pre);

      // reset pre && count
      pre = null;
      count = 1;
    }

    int l;
    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      l = queue.poll();
      sb.append(Integer.toString(l));
    }

    return sb.toString();
  }

  public String countAndSayWithRecursive(int n) {
    String s = "1";
    for (int i = 1; i < n; i++) {
      s = countIdx(s);
    }

    return s;
  }

  public String countIdx(String s) {
    StringBuilder sb = new StringBuilder();
    char c = s.charAt(0);
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        count++;
      } else {
        sb.append(count);
        sb.append(c);

        c = s.charAt(i);
        count = 1;
      }
    }

    sb.append(count);
    sb.append(c);
    return sb.toString();
  }



}
