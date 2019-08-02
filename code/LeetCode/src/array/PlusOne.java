package array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/plus-one/
public class PlusOne {

  public int[] plusOneChangeSource(int[] digits) {
    int len = digits.length;
    for (int i = len - 1; i >= 0; i--) {
      if (digits[i] < 9) {
        digits[i]++;
        return digits;
      }

      digits[i] = 0;
    }

    int[] result = new int[len + 1];
    result[0] = 1;

    return result;
  }

  public int[] plusOne(int[] digits) {
    List<Integer> list = new ArrayList<>();
    int carry = 1;
    int sum;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (carry == 0) {
        list.add(0, digits[i]);
        continue;
      }

      sum = digits[i] + carry;
      carry = sum / 10;
      digits[i] = sum % 10;
      list.add(0, digits[i]);
    }
    // carry is 1, add one in the first
    if (carry == 1) {
      list.add(0, 1);
    }

    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }

    return result;
  }
}
