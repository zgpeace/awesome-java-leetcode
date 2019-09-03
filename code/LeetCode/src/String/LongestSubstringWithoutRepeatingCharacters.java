package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstringWithArray(String s) {
    int max = 0;
    int[] array = new int[128];
    char c;
    for (int i = 0, j = 0; j < s.length(); j++) {
      c = s.charAt(j);
      i = Math.max(array[c], i);
      max = Math.max(max, (j - i + 1));
      array[c] = j + 1;
    }

    return max;
  }

  public int lengthOfLongestSubstringWithMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int max = 0;
    char c;
    for (int i = 0, j = 0; j < s.length(); j++) {
      c = s.charAt(j);
      if (map.containsKey(c)) {
        i = Math.max(i, map.get(c));
      }

      max = Math.max(max, (j - i + 1));
      map.put(c, j + 1);
    }

    return max;
  }

  public int lengthOfLongestSubstringWithSet(String s) {
    Set<Character> set = new HashSet<>();
    int max = 0;
    int left = 0;
    int right = 0;
    char c;
    while (right < s.length()) {
      c = s.charAt(right);
      if (!set.contains(c)) {
        // not contain, add to set, replace max, right++
        set.add(c);
        max = Math.max(max, (right - left + 1));
        right++;
      } else {
        // remove left item, left++
        set.remove(s.charAt(left));
        left++;
      }
    }

    return max;
  }

  public int lengthOfLongestSubstring(String s) {
    int longest = 0;
    String current = "";
    for (char c : s.toCharArray()) {
      if (current.indexOf(c) == -1) {
        current += c;
        if (current.length() > longest) {
          longest = current.length();
        }
        continue;
      }

      int index = current.indexOf(c);
      current += c;
      current = current.substring(index + 1);
    }

    return longest;
  }
}
