package String;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {

  public static void main(String[] args) {
    String input = "IV";
    romanToInt(input);
  }

  public int romanToIntWithMap(String s) {
    Map<Character, Integer> charMap = new HashMap<>();
    charMap.put('I', 1);
    charMap.put('V', 5);
    charMap.put('X', 10);
    charMap.put('L', 50);
    charMap.put('C', 100);
    charMap.put('D', 500);
    charMap.put('M', 1000);
    int pre = 0;
    int sum = 0;
    int current;
    for (int i = s.length() - 1; i >= 0; i--) {
      current = charMap.get(s.charAt(i));
      if (current >= pre) {
        sum += current;
      } else {
        sum -= current;
      }
      pre = current;
    }

    return sum;
  }


  public int romanToIntReverseOrder(String s) {
    if (s == null || s.length() == 0) {
      return -1;
    }
    int sum = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      switch (s.charAt(i)) {
        case 'I': {
          sum += (sum >= 5 ? -1 : 1);
          break;
        }
        case 'V': {
          sum += 5;
          break;
        }
        case 'X': {
          sum += 10 * (sum >= 50 ? -1 : 1);
          break;
        }
        case 'L': {
          sum += 50;
          break;
        }
        case 'C': {
          sum += 100 * (sum >= 500 ? -1 : 1);
          break;
        }
        case 'D': {
          sum += 500;
          break;
        }
        case 'M': {
          sum += 1000;
          break;
        }
      }
    }

    return sum;
  }

  public static int romanToInt(String s) {
    Map<String, Integer> doubleMap = new HashMap<>();
    doubleMap.put("IV", 4);
    doubleMap.put("IX", 9);
    doubleMap.put("XL", 40);
    doubleMap.put("XC", 90);
    doubleMap.put("CD", 400);
    doubleMap.put("CM", 900);
    int sum = 0;
    for (String item: doubleMap.keySet()) {
      if (s.contains(item)) {
        sum += doubleMap.get(item);
        s = s.replace(item, "");
      }
    }

    Map<Character, Integer> charMap = new HashMap<>();
    charMap.put('I', 1);
    charMap.put('V', 5);
    charMap.put('X', 10);
    charMap.put('L', 50);
    charMap.put('C', 100);
    charMap.put('D', 500);
    charMap.put('M', 1000);
    for (char c: s.toCharArray()) {
      sum += charMap.get(c);
    }

    return sum;
  }
}
